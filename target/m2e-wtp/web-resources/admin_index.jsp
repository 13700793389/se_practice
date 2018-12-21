<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="src/common/layui/css/layui.css" />
<title>管理员页</title>
</head>
<style>
	*{
		box-sizing: border-box;
	}
	#mainbody {
		width: 50%;
		margin-left: auto;
		margin-right: auto;
	}
</style>
<body>
	<div id="mainbody">
		<div class="layui-container">
		<div class="layui-row">
		<div class="layui-tab layui-tab-card">
  			<ul class="layui-tab-title">
			    <li class="layui-this">设置选课时间</li>
			    <li>添加课程</li>
			    <li>发布公告</li>
  			</ul>
	  		<div class="layui-tab-content">
			    <div class="layui-tab-item layui-show">
					<form class="layui-form layui-form-pane" action="">
  							<div>
	    						<label class="layui-form-label">选课开关</label>
	    						<div class="layui-input-inline" style="width: 300px;">
	      						<select name="timetable">
							        <option value="0">关闭</option>
							        <option value="1">开启</option>
	      						</select>
	      						</div>
    						</div>
						<div class="layui-form-item" style="margin-top: 10px">
    						<div class="layui-input-block">
      							<button class="layui-btn" lay-submit lay-filter="sub3">立即提交</button>
      							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
    				  		</div>
  					  	</div>
					</form>
				</div>
			    <div class="layui-tab-item">
			    	<form class="layui-form layui-form-pane" action="">
			    		 <div class="layui-form-item">
			    		 	<div class="layui-inline">
	    						<label class="layui-form-label">课程id</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_id" required autocomplete="off" class="layui-input">
		    					</div>
		    				</div>
	  						<div class="layui-inline">
	    						<label class="layui-form-label">课程名称</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_name" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
	    					<div class="layui-inline">
	    						<label class="layui-form-label">节数</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_period" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
	    					<div class="layui-inline">
	    						<label class="layui-form-label">开课周次</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_week" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
  						</div>
  						<div class="layui-form-item">
  							<div class="layui-inline">
	    						<label class="layui-form-label">学分</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_credit" required autocomplete="off" class="layui-input">
		    					</div>
  							</div>
  							<div class="layui-inline">
	    						<label class="layui-form-label">学位课</label>
	    						<div class="layui-input-inline" style="width: 100px;">
	      						<select name="course_isdegree">
							        <option value="0">否</option>
							        <option value="1">是</option>
	      						</select>
	      						</div>
    						</div>
    						<div class="layui-inline">
	    						<label class="layui-form-label">教授教师</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_teacher" required autocomplete="off" class="layui-input">
		    					</div>
  							</div>
  							<div class="layui-inline">
	    						<label class="layui-form-label">学院</label>
	    						<div class="layui-input-inline" style="width: 200px;">
	      						<select name="course_department">
									<option value="数学学院">数学学院</option>
									<option value="物理学院">物理学院</option>
									<option value="计算机学院">计算机学院</option>
									<option value="人工智能学院">人工智能学院</option>
									<option value="网络空间安全学院">网络空间安全学院</option>
	      						</select>
	    						</div>
	    					</div>
  						</div>
  						<div class="layui-form-item">
  							<div class="layui-inline">
	    						<label class="layui-form-label">课程属性</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_character" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
	    					<div class="layui-inline">
	    						<label class="layui-form-label">上课时间</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_section" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
	    					<div class="layui-inline">
	    						<label class="layui-form-label">开课地点</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_site" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
	    					  	<div class="layui-inline">
	    						<label class="layui-form-label">限选人数</label>
		    					<div class="layui-input-inline" style="width: 100px;">
		      						<input type="text" name="course_limitselection" required autocomplete="off" class="layui-input">
		    					</div>
	    					</div>
  						</div>
  						<div class="layui-form-item">
    						<label class="layui-form-label">考核方式</label>
	    					<div class="layui-input-block" style="width: 400px;">
	      						<input type="text" name="course_examination" required autocomplete="off" class="layui-input">
	    					</div>
  						</div>
  						<div class="layui-form-item layui-form-text">
    						<label class="layui-form-label">课程要求</label>
    						<div class="layui-input-block">
      						<textarea name="course_require" placeholder="请输入内容" class="layui-textarea"></textarea>
    						</div>
  						</div>
  						<div class="layui-form-item layui-form-text">
    						<label class="layui-form-label">课程大纲</label>
    						<div class="layui-input-block">
      						<textarea name="course_outline" id="richedit1" style="display: none;"></textarea>
    						</div>
  						</div>
  						 <div class="layui-form-item">
    						<div class="layui-input-block">
      							<button class="layui-btn" lay-submit lay-filter="sub1">立即提交</button>
      							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
    						</div>
  						</div>
			    	</form>
			    </div>
			    <div class="layui-tab-item">
					<form class="layui-form layui-form-pane" action="">
					 	<div class="layui-form-item">
						    <label class="layui-form-label">标题</label>
						    <div class="layui-input-block" style="width: 600px;">
						      <input name="notice_title" class="layui-input" type="text" autocomplete="off">
						    </div>
					  	</div>
						<div class="layui-form-item">
						    <label class="layui-form-label">选择部门</label>
						    <div class="layui-input-block" style="width: 200px;">
						    	<input name="notice_department" class="layui-input" type="text" autocomplete="off">
						    </div>
					  	</div>
					  	<div class="layui-form-item">
						    <div class="layui-inline">
						      <label class="layui-form-label">日期选择</label>
						      <div class="layui-input-block">
						        <input name="notice_date" class="layui-input" id="date" type="text" autocomplete="off">
						      </div>
						    </div>
					  	</div>
					  	<div class="layui-form-item layui-form-text">
						    <label class="layui-form-label">内容</label>
						    <div class="layui-input-block">
						      <textarea name="notice_content" id="richedit2" style="display: none;"></textarea>
						    </div>
					  	</div>
					  	<div class="layui-form-item">
    						<div class="layui-input-block">
      							<button class="layui-btn" lay-submit lay-filter="sub2">立即提交</button>
      							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
    				  		</div>
  					  	</div>
					</form>
			    </div>
	  		</div>
	  	</div>
		</div>
		</div>
	</div>
	<script type="text/javascript" src="src/common/layui/layui.js" ></script>
	<script type="text/javascript" src="src/common/lib/jquery-1.9.0.min.js" ></script>
	<script>
	layui.use(['element','form','layedit','laydate'], function(){
		  var element = layui.element;
		  var form = layui.form;
		  var layedit = layui.layedit;
		  var laydate = layui.laydate;
		  laydate.render({
			    elem: '#date'
			  });
		  var index1 = layedit.build('richedit1', {
			  tool: ['strong','italic','|','left','center','right']
			});  
		  var index2 = layedit.build('richedit2', {
			  tool: ['strong','italic','|','left','center','right']
			});  
		  form.on('submit(sub1)', function(data){
			 var course_id = data.field["course_id"];
			 var course_name = data.field["course_name"];
			 var course_period = data.field["course_period"];
			 var course_week = data.field["course_week"];
			 var course_credit = data.field["course_credit"];
			 var course_isdegree = data.field["course_isdegree"];
			 var course_teacher = data.field["course_teacher"];
			 var course_department = data.field["course_department"];
			 var course_character = data.field["course_character"];
			 var course_section = data.field["course_section"];
			 var course_site = data.field["course_site"];
			 var course_limitselection = data.field["course_limitselection"];
			 var course_examination = data.field["course_examination"];
			 var course_require = data.field["course_require"];
			 var course_outline = layedit.getContent(index1);
             $.ajax({
            	 url: 'releasecourse',
                 data: {"id":course_id, "name":course_name, "period":course_period, "week":course_week, "credit":course_credit, "isdegree":course_isdegree, "teacher":course_teacher,"department":course_department, "character":course_character, "section":course_section,
                	 "site":course_site, "limitselection":course_limitselection, "examination":course_examination, "require":course_require, "outline":course_outline},
                 dataType: 'text',//预期得到的数据类型
                 type: 'post',
                 success:function (data) {
                     if (data == 0){
                    	 layer.msg("已发布过该课程,请勿重复操作");
                     }else if(data == 1){
                    	 layer.msg("发布成功");
                     }else{
                    	 layer.msg("出错了");
                     }
                 }
             })
             return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		  });
		  form.on('submit(sub2)', function(data){
			  
				 var notice_title = data.field["notice_title"];
				 var notice_department = data.field["notice_department"];
				 var notice_date = data.field["notice_date"];
				 var notice_content = layedit.getContent(index2);
	             $.ajax({
	            	 url: 'releasenotice',
	            	 data:{"title":notice_title, "department":notice_department,"date":notice_date,"content":notice_content},
	                 dataType: 'text',//预期得到的数据类型
	                 type: 'post',
	                 success:function (data) {
	                     if (data == 1){
	                    	 layer.msg("发布成功");
	                     }else{
	                    	 layer.msg("出错了");
	                     }
	                 }
	             })
	             return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
		  form.on('submit(sub3)', function(data){
			  
				 var timetable_switch = data.field["timetable"];;
	          $.ajax({
	         	 url: 'updatetimetable',
	         	 data:{"switch":timetable_switch},
	              dataType: 'text',//预期得到的数据类型
	              type: 'post',
	              success:function (data) {
	            	  layer.msg("更改成功");
	              }
	          })
	          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	});
	</script>
</body>
</html>