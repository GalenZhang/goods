package com.goods.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default") 
@Namespace(value = "/nkindeditor")
public class GUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 514494604734764988L;
	private File[] imgFile; // 上传的文件
	private String[] imgFileFileName; // 文件名称
	private String[] imgFileContentType; // 文件类型
	private static long maxSize = 1000000;
	public Map<String, String> obj;
	
	private static Map<String, String> extMap = new HashMap<String, String>();
	static {

		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

	}
	

	@Action(value = "upload",  results={
			@Result(name = "json",type="json")
			})
	public @ResponseBody String upload() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		obj = new HashMap<String, String>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter writer = response.getWriter();
		if (!ServletFileUpload.isMultipartContent(request)) {
			//writer.println(getError("请选择文件。"));
			setError("上传失败");
			return "json";
		}

		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/attached/");
		String saveUrl = request.getContextPath() + "/attached/";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += "/" + ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}

		if (imgFile != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			File savedir = new File(savePath);
			if (!savedir.getParentFile().exists())
				savedir.getParentFile().mkdirs();
			for (int i = 0; i < imgFile.length; i++) {
				String fileExt = imgFileFileName[i].substring(
						imgFileFileName[i].lastIndexOf(".") + 1).toLowerCase();

				if (extMap.get(dirName).indexOf(fileExt) < 0) {
//					writer.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
//							+ extMap.get(dirName) + "格式。"));
					setError("上传失败");
					return "json";
				}
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;
				File savefile = new File(savedir, newFileName);

				if (imgFile[i].length() > maxSize) {
					//writer.println(getError("上传文件大小超过限制。"));
					setError("上传失败");
					return "json";
				}

				FileUtils.copyFile(imgFile[i], savefile);
				obj.put("error", "0");
				obj.put("url", saveUrl + newFileName);
			}
			//ActionContext.getContext().put("message", "文件上传成功");
			//obj = ResultUtil.getJSONObject(1, "上传失败");
		}
		
		return "json";
	}

	@JSON(serialize=false)  
	public File[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(File[] imgFile) {
		this.imgFile = imgFile;
	}

	@JSON(serialize=false)  
	public String[] getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String[] imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	@JSON(serialize=false)  
	public String[] getImgFileContentType() {
		return imgFileContentType;
	}

	public void setImgFileContentType(String[] imgFileContentType) {
		this.imgFileContentType = imgFileContentType;
	}

	public Map<String, String> getObj() {
		return obj;
	}

	public void setObj(Map<String, String> obj) {
		this.obj = obj;
	}

	private void setError(String message) {
		obj.put("error", "1");
		obj.put("message", message);
	}

}
