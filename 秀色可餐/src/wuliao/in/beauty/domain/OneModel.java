package wuliao.in.beauty.domain;

public class OneModel {
	private String imgPath;
	private String title;
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public OneModel(String imgPath, String title) {
		this.imgPath = imgPath;
		this.title = title;
	}
	
}
