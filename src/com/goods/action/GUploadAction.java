package com.goods.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace(value = "/upload")
public class GUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 514494604734764988L;
	private File[] imgFile; // 上传的文件
	private String[] imgFileFileName; // 文件名称
	private String[] imgFileContentType; // 文件类型
	private static long maxSize = 1000000;
	private static Map<String, String> extMap = new HashMap<String, String>();
	static {

		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

	}

	@SuppressWarnings("unchecked")
	@Action(value = "upload")
	public void upload() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		if (!ServletFileUpload.isMultipartContent(request)) {
			writer.println(getError("请选择文件。"));
			return;
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
					writer.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
							+ extMap.get(dirName) + "格式。"));
					return;
				}
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;
				File savefile = new File(savedir, newFileName);

				if (imgFile[i].length() > maxSize) {
					writer.println(getError("上传文件大小超过限制。"));
					return;
				}

				FileUtils.copyFile(imgFile[i], savefile);
				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", saveUrl + newFileName);
				writer.println(obj.toJSONString());
			}
			ActionContext.getContext().put("message", "文件上传成功");
		}
		
		writer.println(getError("上传文件大小超过限制。"));
		return;
	}

	public void addActionError(String anErrorMessage) {
		// 这里要先判断一下，是我们要替换的错误，才处理

		if (anErrorMessage
				.startsWith("the request was rejected because its size")) {

			Matcher m = Pattern.compile("//d+").matcher(anErrorMessage);

			String s1 = "";

			if (m.find())
				s1 = m.group();

			String s2 = "";

			if (m.find())
				s2 = m.group();

			try {
				ServletActionContext.getResponse().getWriter().println(getError("上传文件大小超过限制。"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//super.addActionError("你上传的文件大小（" + s1 + "）超过允许的大小（" + s2 + "）");
			return;
			
			// 偷梁换柱，将信息替换掉
			
			// 也可以改为在Field级别的错误
			// super.addFieldError("file","你上传的文件大小（" + s1 + "）超过允许的大小（" + s2 +
			// "）");

		} else {// 否则按原来的方法处理
			super.addActionError(anErrorMessage);
		}
	}
	
	public File[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(File[] imgFile) {
		this.imgFile = imgFile;
	}

	public String[] getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String[] imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public String[] getImgFileContentType() {
		return imgFileContentType;
	}

	public void setImgFileContentType(String[] imgFileContentType) {
		this.imgFileContentType = imgFileContentType;
	}

	@SuppressWarnings("unchecked")
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}

}
