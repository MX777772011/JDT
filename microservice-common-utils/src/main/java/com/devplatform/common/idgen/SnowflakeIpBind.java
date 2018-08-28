package com.devplatform.common.idgen;

import com.devplatform.common.utils.IpUtil;


/**
 * Twitter 使用的Snowflake
 * 因为使用snowflake的时候，需要从zookeeper中获取workerid，大部分项目用不到
 * 所以开发出此衍生版，根据服务器mac地址来生成workId，去掉zookeeper
 * @author yangzc
 *
 */

public class SnowflakeIpBind {
//    private final static Logger logger = LoggerFactory.getLogger(IdWorker.class);

    private final long workerId;
    private final long snsEpoch = 1288834974657L;// 起始标记点，作为基准
    private long sequence = 0L;// 0，并发控制
    private final long workerIdBits = 8L;// 只允许workid的范围为：0-256
    private final long maxWorkerId = -1L ^ -1L << this.workerIdBits;// 1023,1111111111,10位
    private final long sequenceBits = 12L;// sequence值控制在0-4095

//    private final long workerIdShift = this.sequenceBits;// 12
    private final long workerIdShift = this.sequenceBits;
    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;// 22
    private final long sequenceMask = -1L ^ (-1L << this.sequenceBits);// 4095,111111111111,12位

    private long lastTimestamp = -1L;
    
    public SnowflakeIpBind() {
    	super();
    	Long nworkid=getWorkerIdFromIp();
//    	System.out.println("初始化workid："+nworkid);
    	this.workerId = nworkid;
    }
    
    //恶汉单利，直接初始化
    private static final SnowflakeIpBind single = new SnowflakeIpBind();  
    //静态工厂方法   
    public  static SnowflakeIpBind getInstance() {  
        return single;  
    }  

    
    
    private long getWorkerIdFromIp(){
    	String ip=IpUtil.getLocalIP();
    	if(ip.indexOf(".")==-1){
    		return 0;
    	}else{
    		String[] address=ip.split("\\.");
//    		return Long.valueOf(address[2]+""+address[3]);
    		return Long.valueOf(address[3]);//目前大部分项目都是机器末位IP不同，所以仅取最后ip即可
    	}
    }

    @SuppressWarnings("unused")
	private SnowflakeIpBind(long workerId) {
        super();
        if (workerId > this.maxWorkerId || workerId < 0) {// workid < 1024[10位：2的10次方]
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() throws Exception {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {// 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环)，下次再使用时sequence是新值
            //System.out.println("lastTimeStamp:" + lastTimestamp);
//        	System.out.println(this.sequence+"@@@");
            this.sequence = this.sequence + 1 & this.sequenceMask;
//            System.out.println(this.sequence+"###");
            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);// 重新生成timestamp
            }
        }
        else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
//            logger.error(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
            throw new Exception(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        // 生成的timestamp
//        System.out.println(timestamp - this.snsEpoch << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence);
        return timestamp - this.snsEpoch << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence;
    }

    /**
     * 保证返回的毫秒数在参数之后
     * 
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /**
     * 获得系统当前毫秒数
     * 
     * @return
     */
    private long timeGen() {
//    	System.out.println(System.currentTimeMillis()+"###");
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
    	SnowflakeIpBind work2=new SnowflakeIpBind();
    	System.out.println(work2.nextId());

    }
}