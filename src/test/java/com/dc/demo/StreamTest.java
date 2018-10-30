package com.dc.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dc.improve.model.entity.User;
import com.dc.improve.model.entity.VideoMsg;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.HtmlUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/8/30 下午3:20
 **/
public class StreamTest {

    @Test
    public void testSorted(){
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId(4);
        users.add(user);
        User user2 = new User();
        user2.setId(2);
        users.add(user2);
        User user3 = new User();
        user3.setId(3);
        users.add(user3);
        System.out.println(JSON.toJSONString(users));
        users=users.stream().sorted(Comparator.comparingInt(User::getId)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));

    }

    /**
     * {
     *     "authorizer_info": {
     *         "nick_name": "钱多多抢购",
     *         "service_type_info": {
     *             "id": 2
     *         },
     *         "verify_type_info": {
     *             "id": 0
     *         },
     *         "user_name": "gh_ab2657cac93f",
     *         "alias": "Money-_-Dodo",
     *         "qrcode_url": "http://mmbiz.qpic.cn/mmbiz_jpg/DvVZm6wLZaSfFd26XhdvMdqAbgo5F2aO0KT3F7gTOk8uImxqiaOh4ExLUo7IbtYooJUxAXMiak4O7ufBNRL7PyIg/0",
     *         "business_info": {
     *             "open_pay": 0,
     *             "open_shake": 0,
     *             "open_scan": 0,
     *             "open_card": 0,
     *             "open_store": 0
     *         },
     *         "idc": 1,
     *         "principal_name": "北京豆豆兄弟投资管理中心(有限合伙)",
     *         "signature": "酒店抢购产品聚集地"
     *     },
     *     "authorization_info": {
     *         "authorizer_appid": "wxcc878e3a91463bb5",
     *         "func_info": [
     *             {
     *                 "funcscope_category": {
     *                     "id": 1
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 15
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 4
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 7
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 2
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 3
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 11
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 6
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 5
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 8
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 13
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 9
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 10
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 12
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 22
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 23
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 24
     *                 },
     *                 "confirm_info": {
     *                     "need_confirm": 0,
     *                     "already_confirm": 0,
     *                     "can_confirm": 0
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 26
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 27
     *                 },
     *                 "confirm_info": {
     *                     "need_confirm": 0,
     *                     "already_confirm": 0,
     *                     "can_confirm": 0
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 33
     *                 },
     *                 "confirm_info": {
     *                     "need_confirm": 0,
     *                     "already_confirm": 0,
     *                     "can_confirm": 0
     *                 }
     *             },
     *             {
     *                 "funcscope_category": {
     *                     "id": 35
     *                 }
     *             }
     *         ]
     *     }
     * }
     */
    @Test
    public void testJson(){
        String json = "{\n" +
                "    \"authorizer_info\": {\n" +
                "        \"nick_name\": \"钱多多抢购\",\n" +
                "        \"service_type_info\": {\n" +
                "            \"id\": 2\n" +
                "        },\n" +
                "        \"verify_type_info\": {\n" +
                "            \"id\": 0\n" +
                "        },\n" +
                "        \"user_name\": \"gh_ab2657cac93f\",\n" +
                "        \"alias\": \"Money-_-Dodo\",\n" +
                "        \"qrcode_url\": \"http://mmbiz.qpic.cn/mmbiz_jpg/DvVZm6wLZaSfFd26XhdvMdqAbgo5F2aO0KT3F7gTOk8uImxqiaOh4ExLUo7IbtYooJUxAXMiak4O7ufBNRL7PyIg/0\",\n" +
                "        \"business_info\": {\n" +
                "            \"open_pay\": 0,\n" +
                "            \"open_shake\": 0,\n" +
                "            \"open_scan\": 0,\n" +
                "            \"open_card\": 0,\n" +
                "            \"open_store\": 0\n" +
                "        },\n" +
                "        \"idc\": 1,\n" +
                "        \"principal_name\": \"北京豆豆兄弟投资管理中心(有限合伙)\",\n" +
                "        \"signature\": \"酒店抢购产品聚集地\"\n" +
                "    },\n" +
                "    \"authorization_info\": {\n" +
                "        \"authorizer_appid\": \"wxcc878e3a91463bb5\",\n" +
                "        \"func_info\": [\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 1\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 15\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 4\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 7\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 2\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 3\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 11\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 6\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 5\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 8\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 13\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 9\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 10\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 12\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 22\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 23\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 24\n" +
                "                },\n" +
                "                \"confirm_info\": {\n" +
                "                    \"need_confirm\": 0,\n" +
                "                    \"already_confirm\": 0,\n" +
                "                    \"can_confirm\": 0\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 26\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 27\n" +
                "                },\n" +
                "                \"confirm_info\": {\n" +
                "                    \"need_confirm\": 0,\n" +
                "                    \"already_confirm\": 0,\n" +
                "                    \"can_confirm\": 0\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 33\n" +
                "                },\n" +
                "                \"confirm_info\": {\n" +
                "                    \"need_confirm\": 0,\n" +
                "                    \"already_confirm\": 0,\n" +
                "                    \"can_confirm\": 0\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"funcscope_category\": {\n" +
                "                    \"id\": 35\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(json);
        String authorizationInfo = jsonObject.get("authorization_info").toString();
        String funcInfo = JSON.parseObject(authorizationInfo).get("func_info").toString();
        JSONArray jsonArray = JSON.parseArray(funcInfo);

        for (int i = 0; i < jsonArray.size(); i++) {
            String funcscopeCategory = jsonArray.getJSONObject(i).get("funcscope_category").toString();
            JSONObject jsonObject1 = JSON.parseObject(funcscopeCategory);
            if ("1".equals(jsonObject1.getString("id"))){
                System.out.println(jsonArray.getJSONObject(i));
            }
        }

    }

    @Test
    public void testCompareTo(){
        System.out.println("5:0".compareTo("23:0"));
        String str="a,bb";
        if (str.contains("a")){
            System.out.println("包含a");
        }else if (str.contains("b")){
            System.out.println("包含b");
        }
    }

    @Test
    public void testList(){
        List<Object> list = Lists.newArrayListWithCapacity(10);
        list.add("aa");
        list.add(2);
        list.add('c');
        list.add(3);
        System.out.println(list);

        for (int i = 0; i < 4; i++) {
            Object o = list.remove(0);
            list.add(o);
        }

        System.out.println(list);
    }

    @Test
    public void testByte(){
        Byte b=1;
        Integer i=Integer.parseInt(b.toString());
        System.out.println(i);
    }

    @Test
    public void testMapJson(){
        Map<String, Integer> map = Maps.newHashMap();
        map.put("ENABLE_HOME_MOBILE_BIND",1);
        map.put("ENABLE_BUY_AFTER_MOBILE_BIND",1);
        System.out.println(JSON.toJSONString(map));
        Properties properties = System.getProperties();
        Set<Object> objects = properties.keySet();

        objects.forEach(obj->{
            System.out.println(obj.toString()+"="+properties.get(obj.toString()));
        });
    }

    @Test
    public void testHeaders(){
        HttpHeaders headers = new HttpHeaders();
    }

    @Test
    public void testString(){
        String imagePath="http://pic.zhiketong.cn/h5/2018-10/20181011155938_45077.jpg?x-oss-process=image/resize,m_fill,h_200,w_470,limit_0";
        if (imagePath.contains("?")){
            String s = imagePath.split("\\?")[0];
            System.out.println(s);
        }
    }

    @Test
    public void testFile() throws Exception {
        String imgPath="http://pic.zhiketong.cn/h5/2018-10/20181011155938_45077.jpg";
        URL url = new URL(imgPath);
        //打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置请求方式为"POST"
        conn.setRequestMethod("GET");
        //超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            //通过输入流获取图片数据
            inStream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            byte[] data = readInputStream(inStream);
            if (imgPath.contains("?")){
                imgPath = imgPath.split("\\?")[0];
            }

            String fileExtend = imgPath.substring(imgPath.lastIndexOf(".") + 1);
            LocalDate now = LocalDate.now();
            String filePath = "material_" + now.getYear() + "_" + now.getMonthValue() + "_" + now.getDayOfMonth()+"_"+System.currentTimeMillis() + "." + fileExtend;
            File imageFile = new File(filePath);
            //创建输出流
            outStream = new FileOutputStream(imageFile);
            //写入数据
            outStream.write(data);



        } finally {
            if (Objects.nonNull(inStream)) {
                inStream.close();
            }
            if (Objects.nonNull(outStream)) {
                outStream.close();
            }
        }

    }

    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024 * 4];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len;
        //使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

    @Test
    public void testJson2(){
        String json="{" +
                "    \"touser\":\"OPENID\"," +
                "    \"msgtype\":\"video\"," +
                "    \"video\":" +
                "    {" +
                "      \"media_id\":\"MEDIA_ID\"," +
                "      \"thumb_media_id\":\"MEDIA_ID\"," +
                "      \"title\":\"TITLE\"," +
                "      \"description\":\"DESCRIPTION\"" +
                "    }" +
                "}";

        VideoMsg videoMsg = JSON.parseObject(json, VideoMsg.class);
        System.out.println(JSON.toJSONString(videoMsg));
    }

    @Test
    public void testEscapeHtml(){
        System.out.println(StringEscapeUtils.escapeHtml4("dfjasldfj//<be>%%*%%*"));
        String str="{\"brandId\":5,\"hotelId\":5,\"userId\":\"150692\",\"replyWay\":0,\"keyWordRequestParamVOList\":[{\"keyWord\":\"嘎嘎\\\\\",\"matchType\":0}],\"name\":\"<br>\",\"replyContentRequestParamVOList\":[{\"customizeRichTextVOList\":[],\"materialLibRichTextVOList\":[],\"hyperlinkVOList\":[],\"textVOList\":[{\"contentType\":3,\"text\":\"<hr>fdsjf范德萨发几点睡\"}],\"pictureVOList\":[]}]}";
        System.out.println(StringEscapeUtils.escapeHtml3(str));
        System.out.println("----------------");
        System.out.println(StringEscapeUtils.escapeJava(str));
        System.out.println("----------------");
        System.out.println(StringEscapeUtils.unescapeJava(str));
        System.out.println("----------------");
        System.out.println(StringEscapeUtils.unescapeJson(str));
        System.out.println("----------------");
        System.out.println(StringEscapeUtils.escapeJson(str));
        Pattern pattern = Pattern.compile("%");
        Matcher matcher = pattern.matcher("fjdl富家大室冷风机<be>\\\\%%*");
        String s = matcher.replaceAll("&#37;");
        System.out.println(s);
        System.out.println(StringEscapeUtils.escapeHtml4("\\\\\\"));
        System.out.println(HtmlUtils.htmlEscape("\\\\\\"));
    }

    @Test
    public void testJson3(){
        byte[] bytes = new byte[0];
        System.out.println(JSON.toJSONString(bytes));
    }


}
