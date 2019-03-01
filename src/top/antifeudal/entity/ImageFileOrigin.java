package top.antifeudal.entity;

/**
 * 文件地区对照表，关联文件和地区
 * Title: FileOrigin
 * Description: 
 * @author luoxinghan
 * @date 2019年2月25日 上午2:44:10
 *
 */
public class ImageFileOrigin {

	private Integer id;
	
	private Integer fileId;
	
	private Integer originId;

	public ImageFileOrigin() {
		super();
	}

	public ImageFileOrigin(Integer id, Integer fileId, Integer originId) {
		super();
		this.id = id;
		this.fileId = fileId;
		this.originId = originId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originId) {
		this.originId = originId;
	}
}
