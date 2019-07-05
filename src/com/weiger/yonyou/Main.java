/**
 * 单点流量测试 辅助器	实用性小工具
 * 
 *  *版本说明：
 *1.0 		日期：20190701	编码时长 40minute
 *	计时工具   报告填写
 *2.0		日期：20190702	编码时长 15minute
 *	增加配置文件，可配置 文件名 、sheet页 、开始行、 写入列  
 *3.0		日期：20190703、20190704	编码时长：2.5hours+1hours
 *	增加自动化测试功能，搭建了自动化测试架构，实现了在chrome浏览器联动业务操作
 * 
 * 本工具使用的技术      java swing 热键    POI selenium 工程打包  cmdScript
 *
 *
 *	//TODO	待优化点：
 *	1、IE、firefox 浏览器支持
 *	2、支持自动化脚本
 *	3、健壮性：联动、校验、
 *	4、可用性：操作流程优化
 *	5、外观：界面大小、工具透明、高级页签等等
 *	
 *	另外，做的非常仓促，整理一下代码
 *
 *	^_^:就发到3.0了，如果你认可这种思路，可以自己开发维护使用。另外，有nb的突破让我看看 ^_^!
 */ 
package com.weiger.yonyou;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.weiger.yonyou.awt.listenner.KeyBoardListener;

/**
 * 程序入口类
 * @author weiger    
 *
 */
public class Main {
	
	 /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KeyBoardListener frame = new KeyBoardListener();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
/**
*
*	power by weiger	20190701	我的开源主页：https://github.com/weigerlee
*
*/