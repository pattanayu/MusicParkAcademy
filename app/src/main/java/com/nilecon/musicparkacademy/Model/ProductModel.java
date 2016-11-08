package com.nilecon.musicparkacademy.Model;

import java.io.Serializable;

/**
 * Created by tum on 12-Feb-15.
 */
public class ProductModel implements Serializable {

    public String entity_id;
    public String type_id;
    public String sku;
    public String description;
    public String meta_keyword;
    public String short_description;
    public String name;
    public String meta_title;
    public String meta_description;
    public Integer regular_price_with_tax;
    public Integer regular_price_without_tax;
    public Integer final_price_with_tax;
    public Integer final_price_without_tax;
    public String is_saleable;
    public String image_url;
}
