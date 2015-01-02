package com.goods.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace(value="/upload")
public class GUploadAction extends ActionSupport{

    /**
	 * 
	 */
	private static final long serialVersionUID = 514494604734764988L;
	private File[] imgFile; //上传的文件
    private String[] imgFileFileName; //文件名称
    private String[] imgFileContentType; //文件类型

    @SuppressWarnings("unchecked")
	@Action(value="upload")
    public void upload() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        String savePath = ServletActionContext.getServletContext().getRealPath("/attached/");
        String saveUrl  = request.getContextPath() + "/attached/";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        savePath += "/"+ymd + "/";
        saveUrl += ymd + "/";
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
        	dirFile.mkdirs();
        }

        
        if (imgFile != null) {
        	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            File savedir=new File(savePath);
            if(!savedir.getParentFile().exists())
                savedir.getParentFile().mkdirs();
            for(int i=0;i<imgFile.length;i++){
            	String fileExt = imgFileFileName[i].substring(imgFileFileName[i].lastIndexOf(".") + 1).toLowerCase();
            	String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
                File savefile = new File(savedir, newFileName);
                FileUtils.copyFile(imgFile[i], savefile);
                JSONObject obj = new JSONObject();
                obj.put("error", 0);
                obj.put("url", saveUrl + newFileName);
                writer.println(obj.toJSONString());
            }
            ActionContext.getContext().put("message", "文件上传成功");
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




}
