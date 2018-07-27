package kr.or.ddit.file;

public class FileUtil {
	
	public final static String fileUploadPath = "C:/mypro/W/W/A_TeachingMaterial/7.JspSrpgin/fileUpload";
	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC14
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Disposition header로 부터 업로드 파일명을 리턴한다
	* 
	* ex : form-data; name="uploadFile"; filename="mug_obj_151935157760833301.jpg"
	* 
	*/
	public static String getFileName(String contentDisposition){
		String[] fileStr = contentDisposition.split(";");
		String fileName ="";
		for(String str : fileStr){
			if(str.contains("filename")){
				String[] value = str.split("=\"");
				fileName = value[1].substring(0, value[1].indexOf("\""));
				break;
			}
		}
		return fileName;
	}
}
