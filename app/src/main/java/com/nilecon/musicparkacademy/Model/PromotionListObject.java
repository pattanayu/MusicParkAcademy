package com.nilecon.musicparkacademy.Model;

import java.util.List;

/**
 * Created by saenza on 3/2/2559.
 */
public class PromotionListObject {

    /**
     * Promotion : [{"PromotionId":2,"Banner":"https://luckyjewelers.files.wordpress.com/2013/10/diamond-jewelers.jpg?w=300&h=135","Title":"Buying magnificent pieces of jewelry from trustworthy diamond jewelers","PromotionName":"Green Collection","Detail":"In addition to this, the popularity of colored diamonds is on the rise with each passing day. Though, some of the colored diamonds are rare and are not easily available but admired by every individual who love to wear diamond jewelry.","PromotionLink":"https://luckyjewelers.wordpress.com/2013/10/03/buying-magnificent-pieces-of-jewelry-from-trustworthy-diamond-jewelers/","CreateDate":"13/01/2016","ItemList":[{"ItemId":1,"PromotionImage":"http://pngimg.com/upload/jewelry_PNG6771.png"},{"ItemId":2,"PromotionImage":"http://pngimg.com/upload/small/jewelry_PNG6821.png"},{"ItemId":3,"PromotionImage":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQJb8OWeA3ktaqvvnT2_o2FLKBzO51kY34G2AcRU6zMNOCKQqm3"}]}]
     * IsSuccess : true
     * ErrCode : 0
     * ErrMessage :
     */

    private boolean IsSuccess;
    private int ErrCode;
    private String ErrMessage;
    /**
     * PromotionId : 2
     * Banner : https://luckyjewelers.files.wordpress.com/2013/10/diamond-jewelers.jpg?w=300&h=135
     * Title : Buying magnificent pieces of jewelry from trustworthy diamond jewelers
     * PromotionName : Green Collection
     * Detail : In addition to this, the popularity of colored diamonds is on the rise with each passing day. Though, some of the colored diamonds are rare and are not easily available but admired by every individual who love to wear diamond jewelry.
     * PromotionLink : https://luckyjewelers.wordpress.com/2013/10/03/buying-magnificent-pieces-of-jewelry-from-trustworthy-diamond-jewelers/
     * CreateDate : 13/01/2016
     * ItemList : [{"ItemId":1,"PromotionImage":"http://pngimg.com/upload/jewelry_PNG6771.png"},{"ItemId":2,"PromotionImage":"http://pngimg.com/upload/small/jewelry_PNG6821.png"},{"ItemId":3,"PromotionImage":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQJb8OWeA3ktaqvvnT2_o2FLKBzO51kY34G2AcRU6zMNOCKQqm3"}]
     */

    private List<PromotionEntity> Promotion;

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public void setErrCode(int ErrCode) {
        this.ErrCode = ErrCode;
    }

    public void setErrMessage(String ErrMessage) {
        this.ErrMessage = ErrMessage;
    }

    public void setPromotion(List<PromotionEntity> Promotion) {
        this.Promotion = Promotion;
    }

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public int getErrCode() {
        return ErrCode;
    }

    public String getErrMessage() {
        return ErrMessage;
    }

    public List<PromotionEntity> getPromotion() {
        return Promotion;
    }

    public static class PromotionEntity {
        private int PromotionId;
        private String Banner;
        private String Title;
        private String PromotionName;
        private String Detail;
        private String PromotionLink;
        private String CreateDate;
        /**
         * ItemId : 1
         * PromotionImage : http://pngimg.com/upload/jewelry_PNG6771.png
         */

        private List<ItemListEntity> ItemList;

        public void setPromotionId(int PromotionId) {
            this.PromotionId = PromotionId;
        }

        public void setBanner(String Banner) {
            this.Banner = Banner;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public void setPromotionName(String PromotionName) {
            this.PromotionName = PromotionName;
        }

        public void setDetail(String Detail) {
            this.Detail = Detail;
        }

        public void setPromotionLink(String PromotionLink) {
            this.PromotionLink = PromotionLink;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public void setItemList(List<ItemListEntity> ItemList) {
            this.ItemList = ItemList;
        }

        public int getPromotionId() {
            return PromotionId;
        }

        public String getBanner() {
            return Banner;
        }

        public String getTitle() {
            return Title;
        }

        public String getPromotionName() {
            return PromotionName;
        }

        public String getDetail() {
            return Detail;
        }

        public String getPromotionLink() {
            return PromotionLink;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public List<ItemListEntity> getItemList() {
            return ItemList;
        }

        public static class ItemListEntity {
            private int ItemId;
            private String PromotionImage;

            public void setItemId(int ItemId) {
                this.ItemId = ItemId;
            }

            public void setPromotionImage(String PromotionImage) {
                this.PromotionImage = PromotionImage;
            }

            public int getItemId() {
                return ItemId;
            }

            public String getPromotionImage() {
                return PromotionImage;
            }
        }
    }
}
