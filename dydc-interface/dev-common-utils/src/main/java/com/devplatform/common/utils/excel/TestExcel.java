package com.devplatform.common.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.devplatform.common.idgen.IdGenerator;
import com.devplatform.common.utils.ValidateUtil;

import junit.framework.TestCase;

/**
 * 测试
 * 
 */
public class TestExcel extends TestCase {

	private final static String excel2003L = ".xls"; // 2003- 版本的excel
	private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

	/**
	 * 新增
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testAdd() throws Exception {
		//String fileName = "/Users/liyinchu/Documents/ispeak_import/练习2.xlsx";
		String fileName = "C://Users//Administrator//Desktop//iSpeak//导入模板2//导入模板2//练习2.xlsx";
		File excel = new File(fileName);
		InputStream instr = new FileInputStream(excel);
		List<List<String>> sss = getBankListByExcel(instr, fileName);
		listToBean(sss, fileName);
	}

	private static Map<String, String> typeMap;
	private static Map<String, String> sectionMap;
	private static Map<String, Integer> canUseMap;
	private static Map<String, Integer> repartTypeMap;
	static {
		typeMap = new HashMap<String, String>();
		typeMap.put("四级口语", "4");
		typeMap.put("六级口语", "6");
		sectionMap = new HashMap<String, String>();
		sectionMap.put("4_自我介绍", "1");
		sectionMap.put("4_短文朗读", "2");
		sectionMap.put("4_问答", "3");
		sectionMap.put("4_个人陈述", "4");
		sectionMap.put("4_小组互动", "5");
		sectionMap.put("6_讨论", "5500776003858141184");
		sectionMap.put("6_陈述", "5522055302825185280");
		sectionMap.put("6_简短问答", "5522235405299421184");
		sectionMap.put("6_自我介绍", "5522238894691913728");
		sectionMap.put("6_问答", "5570281088363073536");
		sectionMap.put("4_四级全真模拟", "5596156178430496768");
		sectionMap.put("6_六级全真模拟", "6");
		canUseMap = new HashMap<String, Integer>();
		canUseMap.put("可以", 1);
		canUseMap.put("不可以", 0);
		repartTypeMap = new HashMap<String, Integer>();
		repartTypeMap.put("单句跟读", 1);
		repartTypeMap.put("整段跟读", 2);

	}

	public Integer getRepartType(String key){
		Integer s = repartTypeMap.get(key);
		if (s == null) {
			throw new RuntimeException("跟读类型录入不正确");
		}
		return s;
	}
	
	public String getTypeId(String key) {
		String s = typeMap.get(key);
		if (s == null) {
			throw new RuntimeException("考试类型录入不正确");
		}
		return s;

	}

	public int getCanUse(String key) {
		Integer s = canUseMap.get(key);
		if (s == null) {
			throw new RuntimeException("可否试用录入不正确");
		}
		return s;

	}

	public String getSectionId(String typeName, String sectionName) {
		String typeId = getTypeId(typeName);
		String s = sectionMap.get(typeId + "_" + sectionName);
		if (s == null) {
			throw new RuntimeException("考试环节录入不正确");
		}
		return s;
	}

	public Integer toInteger(String source) {
		return Integer.parseInt(source);
	}

	public Practise getPractises(List<List<String>> datas, String resource_path) throws Exception {
		Practise practise = null;
		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(0)) && ValidateUtil.isEmpty(ss.get(1)) && ValidateUtil.isEmpty(ss.get(2)) && ValidateUtil.isEmpty(ss.get(3)) && ValidateUtil.isEmpty(ss.get(4))) {
				continue;//全是空的，忽略这行
			}
			if (ValidateUtil.isEmpty(ss.get(0))) {
				throw new RuntimeException("基本信息录入不正确，缺少考试类型");
			}
			if (ValidateUtil.isEmpty(ss.get(1))) {
				throw new RuntimeException("基本信息录入不正确，缺少考试环节");
			}
			if (ValidateUtil.isEmpty(ss.get(2))) {
				throw new RuntimeException("基本信息录入不正确，缺少练习名称");
			}
			if (ValidateUtil.isEmpty(ss.get(3))) {
				throw new RuntimeException("基本信息录入不正确，缺少免费试用");
			}
			if (ValidateUtil.isEmpty(ss.get(4))) {
				throw new RuntimeException("基本信息录入不正确，缺少排序");
			}
			String practiseId = IdGenerator.generateId();
			practise = new Practise(practiseId, getTypeId(ss.get(0)), getSectionId(ss.get(0), ss.get(1)), ss.get(2), toInteger(ss.get(4)), getCanUse(ss.get(3)));
		}
		return practise;
	}

	public Title getTitle(List<List<String>> datas, String resource_path, String practiseId) throws Exception {
		Title title = null;
		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(5)) && ValidateUtil.isEmpty(ss.get(6))) {
				continue;//全是空的，忽略这行
			}
			if (ValidateUtil.isEmpty(ss.get(5))) {
				throw new RuntimeException("题目信息录入不正确，缺少名称");
			}
			if (ValidateUtil.isEmpty(ss.get(6))) {
				throw new RuntimeException("题目信息录入不正确，缺少录音");
			}
			String titleId = IdGenerator.generateId();
			title = new Title(titleId, practiseId, ss.get(5), resource_path + ss.get(6));
		}
		return title;
	}

	public List<TitleContent> getTitleContents(List<List<String>> datas, String resource_path, String titleId) throws Exception {
		List<TitleContent> titleContents = new ArrayList<TitleContent>();
		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(7)) && ValidateUtil.isEmpty(ss.get(8))) {
				continue;//全是空的，忽略这行
			}
			String titleContentId = IdGenerator.generateId();
			TitleContent titleContent = new TitleContent(titleContentId, titleId, ss.get(7), ValidateUtil.isEmpty(ss.get(8)) ? null : resource_path + ss.get(8));
			titleContents.add(titleContent);
		}
		return titleContents;
	}

	public List<Explain> getExplains(List<List<String>> datas, String resource_path, String practiseId) throws Exception {
		List<Explain> explains = new ArrayList<Explain>();
		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(11)) && ValidateUtil.isEmpty(ss.get(12))) {
				continue;
			}
			if (ValidateUtil.isEmpty(ss.get(11))) {
				throw new RuntimeException("讲解信息录入不正确，缺少一级标题");
			}
			if (ValidateUtil.isEmpty(ss.get(12))) {
				throw new RuntimeException("讲解信息录入不正确，缺少二级标题");
			}
			if (ValidateUtil.isEmpty(ss.get(9))&&ValidateUtil.isNotEmpty(ss.get(10))) {
				throw new RuntimeException("讲解信息录入不正确，模块标题和分类标题需要同时录入");
			}
			if (ValidateUtil.isEmpty(ss.get(10))&&ValidateUtil.isNotEmpty(ss.get(9))) {
				throw new RuntimeException("讲解信息录入不正确，模块标题和分类标题需要同时录入");
			}
			
			Explain explain = new Explain(IdGenerator.generateId(), practiseId, ss.get(9), ss.get(10), ss.get(11), ss.get(12), ValidateUtil.isEmpty(ss.get(13)) ? null : resource_path + ss.get(13));
			explains.add(explain);
		}

		return explains;
	}

	public List<Repart> getReparts(List<List<String>> datas, String resource_path, String practiseId) throws Exception {
		List<Repart> reparts = new ArrayList<Repart>();
		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(15)) && ValidateUtil.isEmpty(ss.get(17))&& ValidateUtil.isEmpty(ss.get(18))) {
				continue;
			}
			if (ValidateUtil.isEmpty(ss.get(15)) || ValidateUtil.isEmpty(ss.get(17))|| ValidateUtil.isEmpty(ss.get(18))) {
				throw new RuntimeException("跟读信息录入不正确，缺少跟读类型或者跟读跟读文本或者跟读压缩包");
			}
			Repart repart = new Repart(IdGenerator.generateId(), getRepartType(ss.get(15)), practiseId, ss.get(14), ss.get(17), ValidateUtil.isEmpty(ss.get(18)) ? null : resource_path + ss.get(18), ValidateUtil.isEmpty(ss.get(16)) ? null : resource_path + ss.get(16));
			reparts.add(repart);
		}
		return reparts;
	}

	public List<Train> getTrains(List<List<String>> datas, String resource_path, String practiseId) throws Exception {
		List<Train> trains = new ArrayList<Train>();

		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(19)) && ValidateUtil.isEmpty(ss.get(20)) && ValidateUtil.isEmpty(ss.get(21)) && ValidateUtil.isEmpty(ss.get(22)) && ValidateUtil.isEmpty(ss.get(23)) && ValidateUtil.isEmpty(ss.get(24))) {
				continue;
			}
			/*if (ValidateUtil.isEmpty(ss.get(21)) || ValidateUtil.isEmpty(ss.get(23))) {
				throw new RuntimeException("训练信息录入不正确，缺少考官视频或者文字");
			}*/
			Train train = new Train(IdGenerator.generateId(), practiseId, ss.get(19), ss.get(23), ValidateUtil.isEmpty(ss.get(21)) ? null : resource_path + ss.get(21), ValidateUtil.isEmpty(ss.get(22)) ? null : resource_path + ss.get(22), ValidateUtil.isEmpty(ss.get(24)) ? null : resource_path + ss.get(24), ss.get(20));
			trains.add(train);
		}
		return trains;
	}
	
	public Practical getPractical(List<List<String>> datas, String resource_path, String practiseId) throws Exception {
		
		Practical practical = null;
		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(0)) && ValidateUtil.isEmpty(ss.get(1)) && ValidateUtil.isEmpty(ss.get(2)) && ValidateUtil.isEmpty(ss.get(3)) && ValidateUtil.isEmpty(ss.get(4))) {
				continue;//全是空的，忽略这行
			}
			if (ValidateUtil.isEmpty(ss.get(0))) {
				throw new RuntimeException("基本信息录入不正确，缺少考试类型");
			}
			if (ValidateUtil.isEmpty(ss.get(1))) {
				throw new RuntimeException("基本信息录入不正确，缺少考试环节");
			}
			if (ValidateUtil.isEmpty(ss.get(2))) {
				throw new RuntimeException("基本信息录入不正确，缺少练习名称");
			}
			if (ValidateUtil.isEmpty(ss.get(3))) {
				throw new RuntimeException("基本信息录入不正确，缺少免费试用");
			}
			if (ValidateUtil.isEmpty(ss.get(4))) {
				throw new RuntimeException("基本信息录入不正确，缺少排序");
			}
			if (ValidateUtil.isEmpty(ss.get(32)) || ValidateUtil.isEmpty(ss.get(33))) {
				throw new RuntimeException("实战中缺少视频图片");
			}
			practical = new Practical(IdGenerator.generateId(), practiseId, ValidateUtil.isEmpty(ss.get(25)) ? null : resource_path + ss.get(25), ss.get(27), ValidateUtil.isEmpty(ss.get(26)) ? null : resource_path + ss.get(26), ss.get(28), ValidateUtil.isEmpty(ss.get(32)) ? null : resource_path + ss.get(32), ValidateUtil.isEmpty(ss.get(33)) ? null : resource_path + ss.get(33));
		}
		return practical;
	}

	
	public List<PracticalTickling> getPracticalTicklings(List<List<String>> datas, String resource_path, String practiseId) throws Exception {
		List<PracticalTickling> practicalTicklings = new ArrayList<PracticalTickling>();

		for (int i = 0; i < datas.size(); i++) {
			List<String> ss = datas.get(i);
			if (ValidateUtil.isEmpty(ss.get(29)) && ValidateUtil.isEmpty(ss.get(30)) && ValidateUtil.isEmpty(ss.get(31))) {
				continue;
			}
			if (ValidateUtil.isEmpty(ss.get(29)) || ValidateUtil.isEmpty(ss.get(30)) || ValidateUtil.isEmpty(ss.get(31))) {
				throw new RuntimeException("实战示例信息录入不正确，缺少名称或者脚本或者录音文件");
			}
			PracticalTickling practicalTickling = new PracticalTickling(IdGenerator.generateId(), practiseId, ValidateUtil.isEmpty(ss.get(31)) ? null : resource_path + ss.get(31), ss.get(29),ss.get(30));
			practicalTicklings.add(practicalTickling);
		}
		return practicalTicklings;
	}
	
	public Map<String,Object> listToBean(List<List<String>> datas, String excelName) throws Exception {
		Map<String,Object> excelData =new HashMap<String,Object>();
		if(excelName.indexOf(excel2007U) == -1 && excelName.indexOf(excel2003L) == -1){
			throw new Exception("文件格式不正确");
		}
		String resource_path = "";
		String parentsPath = excelName.substring(0, excelName.replaceAll("\\\\", "/").lastIndexOf("/"));
		File[] list = new File(parentsPath).listFiles();
		for (File file : list) {
			if(file.isDirectory()){
				resource_path = file.getCanonicalPath() + File.separator;
			}
		}
		/*if (excelName.indexOf(excel2007U) != -1) {
			resource_path = excelName.substring(0, excelName.indexOf(excel2007U)) + File.separator;
		} else if (excelName.indexOf(excel2003L) != -1) {
			resource_path = excelName.substring(0, excelName.indexOf(excel2003L)) + File.separator;
		} else {
			throw new Exception("文件格式不正确");
		}*/
		Practise practise = getPractises(datas, resource_path);
		Title title = getTitle(datas, resource_path, practise.getId());
		List<TitleContent> titleContents = getTitleContents(datas, resource_path, title.getId());
		List<Explain> explains = getExplains(datas, resource_path, practise.getId());
		List<Repart> reparts = getReparts(datas, resource_path, practise.getId());
		List<Train> trains = getTrains(datas, resource_path, practise.getId());
		Practical practical = getPractical(datas, resource_path, practise.getId());
		List<PracticalTickling> practicalTicklings = getPracticalTicklings(datas, resource_path, practise.getId());
		excelData.put("practise", practise);
		excelData.put("title", title);
		excelData.put("titleContents", titleContents);
		excelData.put("explains", explains);
		excelData.put("reparts", reparts);
		excelData.put("trains", trains);
		excelData.put("practical", practical);
		excelData.put("practicalTicklings", practicalTicklings);
		return excelData;
		
	}


	public List<List<String>> getBankListByExcel(InputStream in, String fileName) throws Exception {

		// 创建Excel工作薄
		Workbook work = this.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Row row = null;
		Cell cell = null;

		List<List<String>> list = new ArrayList<List<String>>();
		Sheet sheet = work.getSheetAt(0);
		if (sheet == null) {
			throw new Exception("创建Excel工作薄为空！");
		}
		// 遍历当前sheet中的所有行（不要前2行）
		for (int j = 2; j <= sheet.getLastRowNum(); j++) {
			row = sheet.getRow(j);
			if (row == null) {
				continue;
			}

			// 遍历所有的列
			List<String> li = new ArrayList<String>();
			for (int y = 0; y < 34; y++) {
				cell = row.getCell(y);
				li.add(this.getCellValue(cell));
			}
			list.add(li);
		}
		work.close();
		return list;
	}

	public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (excel2003L.equals(fileType)) {
			wb = new HSSFWorkbook(inStr); // 2003-
		} else if (excel2007U.equals(fileType)) {
			wb = new XSSFWorkbook(inStr); // 2007+
		} else {
			throw new Exception("解析的文件格式有误！");
		}
		return wb;
	}

	/**
	 * 描述：对表格中数值进行格式化
	 * 
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		String value = null;
		DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
		DecimalFormat df2 = new DecimalFormat("0.00"); // 格式化数字

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			value = cell.getRichStringCellValue().getString();
			// value = value.replaceAll("\n", "");
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if ("General".equals(cell.getCellStyle().getDataFormatString())) {
				value = df.format(cell.getNumericCellValue());
			} else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
				value = sdf.format(cell.getDateCellValue());
			} else {
				value = df2.format(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		default:
			break;
		}
		return value;
	}
}
