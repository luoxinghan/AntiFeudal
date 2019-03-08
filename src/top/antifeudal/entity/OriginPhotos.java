package top.antifeudal.entity;

import java.util.ArrayList;

public class OriginPhotos {
	
	private BOrigin bOrigin;
	
	private ArrayList<ImageFile> imageFiles;

	public OriginPhotos() {
		super();
	}

	public OriginPhotos(BOrigin bOrigin, ArrayList<ImageFile> imageFiles) {
		super();
		this.bOrigin = bOrigin;
		this.imageFiles = imageFiles;
	}

	public BOrigin getbOrigin() {
		return bOrigin;
	}

	public void setbOrigin(BOrigin bOrigin) {
		this.bOrigin = bOrigin;
	}

	public ArrayList<ImageFile> getImageFiles() {
		return imageFiles;
	}

	public void setImageFiles(ArrayList<ImageFile> imageFiles) {
		this.imageFiles = imageFiles;
	}
}
