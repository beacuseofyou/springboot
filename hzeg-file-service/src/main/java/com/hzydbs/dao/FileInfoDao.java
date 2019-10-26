package com.hzydbs.dao;

import com.hzydbs.model.FileInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: San Jinhong
 * date: 2019/10/12 12:59
 **/
@Mapper
public interface FileInfoDao {

	@Select("SELECT file_id, file_url, file_type, upload_time, invalid_time, is_delete, app_id FROM t_file_info where id = #{id}")
	FileInfo findById(Integer id);

	@Select("SELECT file_id FROM t_file_info ")
	@Results({@Result(property = "fileId", column = "file_id")})
	List<FileInfo> findFileById();

	@Insert("INSERT INTO t_file_info(file_id, file_url, file_type, upload_time, invalid_time, is_delete, app_id) " +
			"VALUES (#{fileId}, #{fileUrl}, #{fileType}, #{uploadTime}, #{invalidTime}, #{isDelete}, #{appId})")
	//返回自增主键
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insertFileInfo(FileInfo fileInfo);

	@Update("UPDATE t_file_info SET is_delete = #{isDelete} WHERE file_id = #{fileId}")
	void updateIsDeleteByFileId(String fileId, int isDelete);

	@Delete("DELETE FROM t_file_info WHERE file_id= #{fileId}")
	void deleteByFileId(String fileId);

	@Select("SELECT * FROM t_file_info where TO_DAYS(now()) - TO_DAYS(invalid_time) = 1;")
	List<FileInfo> selectByInvalidTime();

	@Delete("DELETE FROM t_file_info WHERE TO_DAYS(now()) - TO_DAYS(invalid_time) = 1 OR is_delete = 1")
	void deleteByValidTimeOrIsDelete();
}
