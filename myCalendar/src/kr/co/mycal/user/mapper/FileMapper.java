package kr.co.mycal.user.mapper;

import kr.co.mycal.user.vo.FileVO;

public interface FileMapper {
	public int insertProfilePic(FileVO file) throws Exception;
	public FileVO selectFilePic(String id) throws Exception;

}
