package com.example.pardeep.resistance;

import android.provider.BaseColumns;

/**
 * Created by Pardeep on 1/12/2016.
 */
public class TableData {
    public TableData(){}

    public static abstract class TableInfo implements BaseColumns{
        public static final String WARRIOR_NAME="warrior_name";
        public static final String WARRIOR_ALLIANCE="warrior_alliance";
        public static final String WARRIOR_SPECIES="warrior_species";
        public static final String WARRIOR_PLANET="warrior_planet";
        public static final String WARRIOR_DATE="warrior_date";
        public static final String WARRIOR_GENDER="gender_status";
        public static final String WARRIOR_IMG="warrior_img";
        public static final String DATABASE_NAME="warriors";
        public static final String TABLE_WARRIORS="warriors";
    }
}
