package com.example.yztx.repository;

import com.example.yztx.domain.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource,Long> {
    //获取最大id，用于获取所上传成功的资源id
    @Query("SELECT max(id) from Resource ")
    Long getMaxId();
}
