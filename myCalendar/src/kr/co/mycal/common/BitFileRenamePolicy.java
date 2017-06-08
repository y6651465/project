package kr.co.mycal.common;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class BitFileRenamePolicy implements FileRenamePolicy{

	public File rename(File f) {
		String name = f.getName(); 
		
		String parent = f.getParent(); 
		
		String ext = "";
		int index = name.lastIndexOf(".");
		
		if(index != -1){
			ext = name.substring(index);
		}
		
		String fName = UUID.randomUUID().toString();
		
		return new File(parent, fName + ext);
	}
}




