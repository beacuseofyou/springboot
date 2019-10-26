package com.hzydbs.utils;


import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Author zhengjun
 */
public class FastDFSClient {

    private static Logger logger = LoggerFactory.getLogger(FastDFSClient.class);
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;

    static{
        try{
            String path = FastDFSClient.class.getResource("/fastdfs-client.properties").getPath();
            ClientGlobal.initByProperties(path);
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
        }catch (Exception e){
            logger.error("FastDFS Client Init Fail",e);
        }
    }

    public static String upload(byte[] fileContent, String fileExt, NameValuePair[] metaList){
        logger.info("File Length:{}",fileContent.length);
        String fileId = null;
        StorageClient1 storageClient1 = null;
        try{
            storageClient1 = getStorageClient1();
            fileId = storageClient1.upload_file1(fileContent,fileExt,metaList);
        }catch (IOException e){
            logger.error("IO Exception when uploading the file",e);
        }catch (MyException e){
            logger.error("non IO Exception when uploading the file",e);
        }

        if (fileId == null && storageClient1!=null){
            logger.error("upload file fail,error code:{}"+storageClient1.getErrorCode());
        }else{
            logger.info("upload file successfully!!file id:{}",fileId);
        }
        return fileId;
    }


    public static FileInfo getFileInfo(String fileId){
        FileInfo fileInfo = null;
        try {
            StorageClient1 storageClient1 = getStorageClient1();
            fileInfo = storageClient1.get_file_info1(fileId);
			fileInfo = storageClient1.query_file_info1(fileId);
		} catch (IOException e) {
            logger.error("IO Exception when getting fileInfo:{}",fileId,e);
        } catch (MyException e) {
            logger.error("non IO Exception when getting fileInfo:{}",fileId,e);
        }
        return fileInfo;
    }

    public static NameValuePair[] getFileMetaList(String fileId){
        NameValuePair[] nameValuePairs = null;
        try{
            StorageClient1 storageClient1 = getStorageClient1();
            nameValuePairs = storageClient1.get_metadata1(fileId);
        } catch (IOException e) {
            logger.error("IO Exception when getting fileMetaList:{}",fileId,e);
        } catch (MyException e) {
            logger.error("non IO Exception when getting fileMetaList:{}",fileId,e);
        }
        return nameValuePairs;
    }


    public static byte[] downloadFile(String fileId){
        byte[] fileBytes = null;
        try {
            StorageClient1 storageClient1 = getStorageClient1();
            fileBytes = storageClient1.download_file1(fileId);
        }catch (IOException e){
            logger.error("IO Exception when downloading file:{}",fileId,e);
        }catch (MyException e){
            logger.error("non IO Exception when downloading file:{}",fileId,e);
        }
        return fileBytes;
    }

    public static int deleteFile(String fileId){
        int i = -1;
        try {
            StorageClient1 storageClient1 = getStorageClient1();
            i = storageClient1.delete_file1(fileId);
        } catch (IOException e) {
            logger.error("IO Exception when deleting file:{}",fileId,e);
        } catch (MyException e) {
            logger.error("IO Exception when deleting file:{}",fileId,e);
        }
        logger.info("delete file successfully!!file id:{}",fileId);
        return i;
    }


    private static StorageClient1 getStorageClient1() throws IOException{
        StorageClient1 storageClient = new StorageClient1(trackerServer,null);
        return storageClient;
    }
}
