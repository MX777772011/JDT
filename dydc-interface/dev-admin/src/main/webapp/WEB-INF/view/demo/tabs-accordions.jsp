<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@include file="/WEB-INF/view/include.jsp" %>

      <div class="row">
        <div class="col-md-6 mb30">
          
        <h5 class="subtitle mb5">Basic Tabs</h5>
        <p>Add quick, dynamic tab functionality to transition through panes of local content.</p>
        <br />
        <!-- Nav tabs -->
        <ul class="nav nav-tabs">
          <li class="active"><a href="#home" data-toggle="tab"><strong>Home</strong></a></li>
          <li><a href="#profile" data-toggle="tab"><strong>Profile</strong></a></li>
          <li><a href="#about" data-toggle="tab"><strong>About</strong></a></li>
          <li><a href="#contact" data-toggle="tab"><strong>Contact</strong></a></li>
        </ul>
        
        <!-- Tab panes -->
        <div class="tab-content mb30">
          <div class="tab-pane active" id="home">
            <h4 class="dark">It has become appallingly obvious that our technology has exceeded our humanity. &nbsp;<small>- Albert Einstein</small></h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat.</p>
          </div>
          <div class="tab-pane" id="profile">
            <div class="row">
              <div class="col-sm-3">
                <img src="images/bimages/photos/profilepic1.png" class="width100p" alt="" />
              </div>
              <div class="col-sm-9">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...</p>
                <button class="btn btn-primary mr5">Follow Me</button>
                <button class="btn btn-white">Send Message</button>
              </div>
            </div>
          </div>
          <div class="tab-pane" id="about">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat</p>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p>
          </div>
          <div class="tab-pane" id="contact">
            <address>
              <strong>Twitter, Inc.</strong><br>
              795 Folsom Ave, Suite 600<br>
              San Francisco, CA 94107<br>
              <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
            <address>
              <strong>Full Name</strong><br>
              <a href="mailto:#">first.last@example.com</a>
            </address>
          </div>
        </div>
        
        <h5 class="subtitle mb5">Nav Justified Tabs</h5>
        <p>Easily make tabs or pills equal widths of their parent.</p>
        <br />
        <!-- Nav tabs -->
        <ul class="nav nav-tabs nav-justified">
          <li class="active"><a href="#home3" data-toggle="tab"><strong>Home</strong></a></li>
          <li><a href="#profile3" data-toggle="tab"><strong>Profile</strong></a></li>
          <li><a href="#about3" data-toggle="tab"><strong>About</strong></a></li>
          <li><a href="#contact3" data-toggle="tab"><strong>Contact</strong></a></li>
        </ul>
        
        <!-- Tab panes -->
        <div class="tab-content">
          <div class="tab-pane active" id="home3">
            <h4 class="dark">It has become appallingly obvious that our technology has exceeded our humanity. &nbsp;<small>- Albert Einstein</small></h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat.</p>
          </div>
          <div class="tab-pane" id="profile3">
            <div class="row">
              <div class="col-sm-3">
                <img src="images/bimages/photos/profilepic1.png" class="width100p" alt="" />
              </div>
              <div class="col-sm-9">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...</p>
                <button class="btn btn-primary mr5">Follow Me</button>
                <button class="btn btn-white">Send Message</button>
              </div>
            </div>
          </div>
          <div class="tab-pane" id="about3">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat</p>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p>
          </div>
          <div class="tab-pane" id="contact3">
            <address>
              <strong>Twitter, Inc.</strong><br>
              795 Folsom Ave, Suite 600<br>
              San Francisco, CA 94107<br>
              <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
            <address>
              <strong>Full Name</strong><br>
              <a href="mailto:#">first.last@example.com</a>
            </address>
          </div>
        </div>
        
      </div><!-- col-md-6 -->
        
        <div class="col-md-6 mb20">
          
        <h5 class="subtitle mb5">Dark Nav Tabs</h5>
        <p>You can use darker tab bar for a nicer look and feel.</p>
        <br />
        <!-- Nav tabs -->
        <ul class="nav nav-tabs nav-dark">
          <li class="active"><a href="#home2" data-toggle="tab"><strong>Home</strong></a></li>
          <li><a href="#profile2" data-toggle="tab"><strong>Profile</strong></a></li>
          <li><a href="#about2" data-toggle="tab"><strong>About</strong></a></li>
          <li><a href="#contact2" data-toggle="tab"><strong>Contact</strong></a></li>
        </ul>
        
        <!-- Tab panes -->
        <div class="tab-content mb30">
          <div class="tab-pane active" id="home2">
            <h4 class="dark">It has become appallingly obvious that our technology has exceeded our humanity. &nbsp;<small>- Albert Einstein</small></h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat.</p>
          </div>
          <div class="tab-pane" id="profile2">
            <div class="row">
              <div class="col-sm-3">
                <img src="images/bimages/photos/profilepic1.png" class="width100p" alt="" />
              </div>
              <div class="col-sm-9">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...</p>
                <button class="btn btn-primary mr5">Follow Me</button>
                <button class="btn btn-white">Send Message</button>
              </div>
            </div>
          </div>
          <div class="tab-pane" id="about2">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat</p>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p>
          </div>
          <div class="tab-pane" id="contact2">
            <address>
              <strong>Twitter, Inc.</strong><br>
              795 Folsom Ave, Suite 600<br>
              San Francisco, CA 94107<br>
              <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
            <address>
              <strong>Full Name</strong><br>
              <a href="mailto:#">first.last@example.com</a>
            </address>
          </div>
        </div>
        
        <h5 class="subtitle mb5">With Dropdown Tabs</h5>
        <p>Add dropdown menus with a little extra HTML.</p>
        <br />
        <!-- Nav tabs -->
        <ul class="nav nav-tabs">
          <li class="active"><a href="#home4" data-toggle="tab"><strong>Home</strong></a></li>
          <li><a href="#profile4" data-toggle="tab"><strong>Profile</strong></a></li>
          <li><a href="#about4" data-toggle="tab"><strong>About</strong></a></li>
          <li><a href="#contact4" data-toggle="tab"><strong>Contact</strong></a></li>
          <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">
              More <span class="caret"></span>
            </a>
            <ul role="menu" class="dropdown-menu pull-right">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="#">Separated link</a></li>
            </ul>
          </li>
        </ul>
        
        <!-- Tab panes -->
        <div class="tab-content">
          <div class="tab-pane active" id="home4">
            <h4 class="dark">It has become appallingly obvious that our technology has exceeded our humanity. &nbsp;<small>- Albert Einstein</small></h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat.</p>
          </div>
          <div class="tab-pane" id="profile4">
            <div class="row">
              <div class="col-sm-3">
                <img src="images/bimages/photos/profilepic1.png" class="width100p" alt="" />
              </div>
              <div class="col-sm-9">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...</p>
                <button class="btn btn-primary mr5">Follow Me</button>
                <button class="btn btn-white">Send Message</button>
              </div>
            </div>
          </div>
          <div class="tab-pane" id="about4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitat</p>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias </p>
          </div>
          <div class="tab-pane" id="contact4">
            <address>
              <strong>Twitter, Inc.</strong><br>
              795 Folsom Ave, Suite 600<br>
              San Francisco, CA 94107<br>
              <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
            <address>
              <strong>Full Name</strong><br>
              <a href="mailto:#">first.last@example.com</a>
            </address>
          </div>
        </div>
        
        </div><!-- col-md-6 -->
        
      </div><!-- row -->
      
      <div class="row">
        <div class="col-md-6">
          
          <h5 class="subtitle">Basic Accordion</h5>
          <p>Get base styles and flexible support for collapsible components like accordions and navigation.</p>
          <br />
          
          <div class="panel-group" id="accordion">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    Collapsible Group Item #1
                  </a>
                </h4>
              </div>
              <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch.
                </div>
              </div>
            </div>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" class="collapsed" data-parent="#accordion" href="#collapseTwo">
                    Collapsible Group Item #2
                  </a>
                </h4>
              </div>
              <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                </div>
              </div>
            </div>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" class="collapsed" data-parent="#accordion" href="#collapseThree">
                    Collapsible Group Item #3
                  </a>
                </h4>
              </div>
              <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                  <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch.</p>
                  <p>Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
                </div>
              </div>
            </div>
          </div>
          
        </div><!-- col-md-6 -->
        
        <div class="col-md-6">
          
          <h5 class="subtitle">Dark Head Accordion</h5>
          <p>Get base styles and flexible support for collapsible components like accordions and navigation.</p>
          <br />
          
          <div class="panel-group panel-group-dark" id="accordion2">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOne2">
                    Collapsible Group Item #1
                  </a>
                </h4>
              </div>
              <div id="collapseOne2" class="panel-collapse collapse in">
                <div class="panel-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch.
                </div>
              </div>
            </div>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" class="collapsed" data-parent="#accordion2" href="#collapseTwo2">
                    Collapsible Group Item #2
                  </a>
                </h4>
              </div>
              <div id="collapseTwo2" class="panel-collapse collapse">
                <div class="panel-body">
                  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                </div>
              </div>
            </div>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" class="collapsed" data-parent="#accordion2" href="#collapseThree2">
                    Collapsible Group Item #3
                  </a>
                </h4>
              </div>
              <div id="collapseThree2" class="panel-collapse collapse">
                <div class="panel-body">
                  <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch.</p>
                  <p>Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
                </div>
              </div>
            </div>
          </div>
          
        </div><!-- col-md-6 -->
        
      </div><!-- row -->
            
    
