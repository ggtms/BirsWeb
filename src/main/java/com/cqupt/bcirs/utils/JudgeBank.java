package com.cqupt.bcirs.utils;

/**
 * @author ggtms
 * @ 2020-04-19 22:27
 */
public class JudgeBank {
    private final static int[] bankNum = {
            955998,622848,622203,621700,621081,622700,436742,521899,622262,622622,622202,
            621226,623063
    };
    //此数组与上面数组的下标一一对应
    private static final  String[] bankName = {
      "中国农业银行·金惠借记卡","中国农业银行","中国工商银行","中国建设银行","中国建设银行 粤通卡·龙卡",
            "中国建设银行·龙卡","中国建设银行","中国交通银行","中国交通银行","浦发银行","中国工商银行",
            "中国工商银行","福建海峡银行"
    };
    public static String getName(String cardnumber) {
        String charBin = cardnumber.substring(0, 6);
        int preNumber = 0, index = 0;
        try {
            preNumber = Integer.valueOf(charBin);

            //判断数值是否存在，若存在则可以返回相应的发卡行
            index = binarySearch(bankNum, preNumber);
            //判断下标在bankname中的位置是否合法
            if (index == -1 || index > bankName.length) {
                return "中国农业银行";
            }
            return bankName[index];
        } catch (NumberFormatException e) {
            return "中国银行";
        }
    }

    /**
     *  在bankNum匹配卡号的前六位
     * @param srcArray 检测标准数组
     * @param preNumber 目标检测值
     * @return 返回检查下标
     */
    public static int binarySearch(int[] srcArray, int preNumber) {
        int low = 0;
        int high = srcArray.length;
        while (low < high) {
            if (preNumber == srcArray[low]) {
                return low;
            }
            low++;
        }
        return -1;
    }
}
