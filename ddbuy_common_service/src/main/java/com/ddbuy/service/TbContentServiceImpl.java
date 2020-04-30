package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.TbContendService;
import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;
import com.ddbuy.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/3/30
 * @Time: 10:29
 **/
//广告接口的实现：  (CRUD 对数据-表的操作：查、改、增、删）

@Service(interfaceClass = TbContendService.class)
@Component
public class TbContentServiceImpl implements TbContendService {
  //实现操作：和数据库交互连接--->sql语句
 @Autowired(required = false)
 private TbContentMapper tbContentMapper;

 @Autowired  //注入redis对象
 private RedisTemplate redisTemplate;

 //添加广告操作
 @Override
 public int addTbContent(TbContent tbContent) {
  //调用mapper持久层操作获取数据:sql语句
  int i = tbContentMapper.insertSelective(tbContent);
  System.out.println(" 添 加 广 告 成 功 ！" );
  //添加完成，更新数据库之后，缓存更新：三步骤

  //创建Redis（数据）操作对象
   ValueOperations<String,List<TbContent>> operations=redisTemplate.opsForValue();
   if (redisTemplate.hasKey("contentList")){ //判断是否有缓存对应的键（值）
    // 1 清空缓存 （对Redis缓存操作）--删除
    redisTemplate.delete("contentList");
    // 2 查询数据库
   /*     TbContentExample tbContentExample=new TbContentExample();
        TbContentExample.Criteria criteria=tbContentExample.createCriteria();
        //查询结果附加条件
        criteria.andStatusEqualTo("1");
        List<TbContent> list = tbContentMapper.selectByExample(tbContentExample);*/
      List<TbContent> list = this.getTbContentList(); //优化操作
    //3 更新缓存
        System.out.println(" 更 新 缓 存 ");
       operations.set("contentList",list);
   }
  return -1;
 }

 //门户广告查询
 @Override
 public List<TbContent> getTbContent() {
//    添加缓存机制，从缓存获取数据
// 判断操作--如果缓存有查询的数据，直接从缓存获取数据；
//         如果缓存没有要查询的数据，将数据库的数据存到缓存
//    判断Redis缓存中是否有对应的键

   //创建redis操作对象
  ValueOperations<String,List<TbContent>> operations= redisTemplate.opsForValue();
  List<TbContent> list=null;
  if (redisTemplate.hasKey("contentList")){
    //从缓存获取数据
   list = operations.get("contentList");
   System.out.println("从缓存redis获取数据");
  }else {
//   缓存中没有键的时候：从数据库mysql中查询，并且
   /*TbContentExample tbContentExample=new TbContentExample();
   TbContentExample.Criteria criteria=tbContentExample.createCriteria();
   //将状态为1的广告展示
   criteria.andStatusEqualTo("1");
   list= tbContentMapper.selectByExample(tbContentExample);*/
   list = this.getTbContentList();  //优化操作
   //将数据库查到的数据存到缓存中
   operations.set("contentList",list);
   System.out.println("从数据库mysql获取数据");
  }
    return list;

/*// 未添加缓存的查询（直接从数据库查询）
  //创建条件对象
  TbContentExample tbContentExample=new TbContentExample();
  TbContentExample.Criteria criteria=tbContentExample.createCriteria();
  //将状态为1的广告展示
  criteria.andStatusEqualTo("1");
  List<TbContent> list= tbContentMapper.selectByExample(tbContentExample);
  return list;*/
 }

 public List<TbContent> getTbContentList(){
  TbContentExample tbContentExample=new TbContentExample();
  TbContentExample.Criteria criteria=tbContentExample.createCriteria();
  //将状态为1的广告展示
  criteria.andStatusEqualTo("1");
  List<TbContent> list= tbContentMapper.selectByExample(tbContentExample);
   return list;
 }

}
