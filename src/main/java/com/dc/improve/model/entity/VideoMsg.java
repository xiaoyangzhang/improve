package com.dc.improve.model.entity;

import java.io.Serializable;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/10/25 3:26 PM
 **/
public class VideoMsg implements Serializable {

    private static final long serialVersionUID = -3018234406294471299L;
    private String touser;
    private String msgtype;
    private Video video;

    class Video {
        private String media_id;
        private String thumb_media_id;
        private String title;
        private String description;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
