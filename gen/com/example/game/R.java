/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.example.game;

public final class R {
    public static final class attr {
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int metaButtonBarButtonStyle=0x7f010001;
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int metaButtonBarStyle=0x7f010000;
    }
    public static final class color {
        public static final int black_overlay=0x7f050000;
    }
    public static final class dimen {
        /**  Default screen margins, per the Android Design guidelines. 

         Example customization of dimensions originally defined in res/values/dimens.xml
         (such as screen margins) for screens with more than 820dp of available width. This
         would include 7" and 10" devices in landscape (~960dp and ~1280dp respectively).
    
         */
        public static final int activity_horizontal_margin=0x7f060000;
        public static final int activity_vertical_margin=0x7f060001;
    }
    public static final class drawable {
        public static final int arrow_left=0x7f020000;
        public static final int arrow_right=0x7f020001;
        public static final int ball=0x7f020002;
        public static final int ball_stroked=0x7f020003;
        public static final int bg_lined=0x7f020004;
        public static final int bg_styled=0x7f020005;
        public static final int bg_styled_ver=0x7f020006;
        public static final int buttonshape=0x7f020007;
        public static final int color1=0x7f020008;
        public static final int color2=0x7f020009;
        public static final int color3=0x7f02000a;
        public static final int color4=0x7f02000b;
        public static final int color5=0x7f02000c;
        public static final int gameover=0x7f02000d;
        public static final int ic_launcher=0x7f02000e;
        public static final int stick=0x7f02000f;
        public static final int stick2=0x7f020010;
    }
    public static final class id {
        public static final int action_settings=0x7f0a000b;
        public static final int btn_help=0x7f0a0003;
        public static final int btn_highScore=0x7f0a0002;
        public static final int btn_play=0x7f0a0001;
        public static final int btn_quit=0x7f0a0004;
        public static final int fullscreen_content=0x7f0a0005;
        public static final int fullscreen_content_controls=0x7f0a0006;
        public static final int relativeLayout1=0x7f0a0000;
        public static final int textView1=0x7f0a0007;
        public static final int textView2=0x7f0a0008;
        public static final int textView3=0x7f0a000a;
        public static final int textView4=0x7f0a0009;
    }
    public static final class layout {
        public static final int activity_full_scr=0x7f030000;
        public static final int activity_game=0x7f030001;
        public static final int activity_help=0x7f030002;
        public static final int activity_high_score=0x7f030003;
    }
    public static final class menu {
        public static final int awa=0x7f090000;
        public static final int game=0x7f090001;
    }
    public static final class raw {
        public static final int au=0x7f040000;
        public static final int tchbrk=0x7f040001;
    }
    public static final class string {
        public static final int action_settings=0x7f07000e;
        public static final int app_name=0x7f070000;
        public static final int hello_world=0x7f070009;
        public static final int help_button=0x7f070003;
        public static final int highScore_button=0x7f070004;
        public static final int high_score_dummy=0x7f07000c;
        public static final int instructionString=0x7f070007;
        public static final int instructions=0x7f070006;
        public static final int messenger=0x7f070011;
        public static final int play_button=0x7f070002;
        public static final int settings_button=0x7f070005;
        public static final int title_activity_full_scr=0x7f070008;
        public static final int title_activity_game=0x7f07000d;
        public static final int title_activity_game_activity=0x7f07000f;
        public static final int title_activity_help=0x7f070001;
        public static final int title_activity_high_score=0x7f07000b;
        public static final int title_activity_main=0x7f07000a;
        public static final int url=0x7f070010;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        
         */
        public static final int AppBaseTheme=0x7f080000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f080001;
        /**  Backward-compatible version of ?android:attr/buttonBarStyle 
         */
        public static final int ButtonBar=0x7f080003;
        /**  Backward-compatible version of ?android:attr/buttonBarButtonStyle 
         */
        public static final int ButtonBarButton=0x7f080004;
        public static final int FullscreenActionBarStyle=0x7f080005;
        public static final int FullscreenTheme=0x7f080002;
    }
    public static final class styleable {
        /** 
         Declare custom theme attributes that allow changing which styles are
         used for button bars depending on the API level.
         ?android:attr/buttonBarStyle is new as of API 11 so this is
         necessary to support previous API levels.
    
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #ButtonBarContainerTheme_metaButtonBarButtonStyle com.example.game:metaButtonBarButtonStyle}</code></td><td></td></tr>
           <tr><td><code>{@link #ButtonBarContainerTheme_metaButtonBarStyle com.example.game:metaButtonBarStyle}</code></td><td></td></tr>
           </table>
           @see #ButtonBarContainerTheme_metaButtonBarButtonStyle
           @see #ButtonBarContainerTheme_metaButtonBarStyle
         */
        public static final int[] ButtonBarContainerTheme = {
            0x7f010000, 0x7f010001
        };
        /**
          <p>This symbol is the offset where the {@link com.example.game.R.attr#metaButtonBarButtonStyle}
          attribute's value can be found in the {@link #ButtonBarContainerTheme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name com.example.game:metaButtonBarButtonStyle
        */
        public static final int ButtonBarContainerTheme_metaButtonBarButtonStyle = 1;
        /**
          <p>This symbol is the offset where the {@link com.example.game.R.attr#metaButtonBarStyle}
          attribute's value can be found in the {@link #ButtonBarContainerTheme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name com.example.game:metaButtonBarStyle
        */
        public static final int ButtonBarContainerTheme_metaButtonBarStyle = 0;
    };
}
