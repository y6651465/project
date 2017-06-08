package kr.co.mycal.user.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mycal.common.BitFileRenamePolicy;
import kr.co.mycal.common.MyAppSqlConfig;
import kr.co.mycal.user.mapper.FileMapper;
import kr.co.mycal.user.vo.FileVO;

@WebServlet("/user/Upload")
public class ProfileUploadServlet extends HttpServlet{
	private SqlSession sqlSession = null;
	private FileMapper fileMapper = null;
	
	public ProfileUploadServlet() {
		sqlSession = MyAppSqlConfig.getSqlSessionInstance();
		fileMapper = sqlSession.getMapper(FileMapper.class);
	}

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		uploadPath+= datePath;
		File f = new File(uploadPath);
		if(!f.exists()){
			f.mkdirs();
		}
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadPath, 
				1024 * 1024 * 10, 
				"utf-8",
				new BitFileRenamePolicy());
		
		f = multi.getFile("profilePic");
		
		if(f != null){
			long size = f.length();
			String oriName = multi.getOriginalFileName("profilePic");
			String sysName = multi.getFilesystemName("profilePic");
					
					
			FileVO file = new FileVO();
			file.setId(multi.getParameter("id"));
			file.setOriName(oriName);
			file.setFilePath(datePath);
			file.setSysName(sysName);
			file.setSize(size);
			
			
			try {
				fileMapper.insertProfilePic(file);
				sqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}









