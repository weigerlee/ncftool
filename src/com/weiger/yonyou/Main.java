/**
 * ������������ ������	ʵ����С����
 * 
 *  *�汾˵����
 *1.0 		���ڣ�20190701	����ʱ�� 40minute
 *	��ʱ����   ������д
 *2.0		���ڣ�20190702	����ʱ�� 15minute
 *	���������ļ��������� �ļ��� ��sheetҳ ����ʼ�С� д����  
 *3.0		���ڣ�20190703��20190704	����ʱ����2.5hours+1hours
 *	�����Զ������Թ��ܣ�����Զ������Լܹ���ʵ������chrome���������ҵ�����
 * 
 * ������ʹ�õļ���      java swing �ȼ�    POI selenium ���̴��  cmdScript
 *
 *
 *	//TODO	���Ż��㣺
 *	1��IE��firefox �����֧��
 *	2��֧���Զ����ű�
 *	3����׳�ԣ�������У�顢
 *	4�������ԣ����������Ż�
 *	5����ۣ������С������͸�����߼�ҳǩ�ȵ�
 *	
 *	���⣬���ķǳ��ִ٣�����һ�´���
 *
 *	^_^:�ͷ���3.0�ˣ�������Ͽ�����˼·�������Լ�����ά��ʹ�á����⣬��nb��ͻ�����ҿ��� ^_^!
 */ 
package com.weiger.yonyou;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.weiger.yonyou.awt.listenner.KeyBoardListener;

/**
 * ���������
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
*	power by weiger	20190701	�ҵĿ�Դ��ҳ��https://github.com/weigerlee
*
*/