package com.hzydbs.dao;

import com.hzydbs.model.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * author: San Jinhong
 * date: 2019/10/12 12:59
 **/
@Mapper
public interface FileInfoDao {

	@Select("SELECT id, file_id fileId, file_url fileUrl, file_type fileType, upload_time uploadTime, invalid_time invalidTime, is_delete isDelete, app_id appId " +
			"FROM t_file_info where id = #{id}")
	FileInfo findById(Integer id);

	@Select("SELECT file_url FROM t_file_info where id = #{id}")
	String findFileUrlById(Integer id);
}
