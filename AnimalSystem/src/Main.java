import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main{
	public static void main(String[] args) {
		Decide decide = new Decide();
		decide.init();
		System.out.println(decide.xMap);
		System.out.println("请输入判断的条件，用空格隔开：");
		String input = "";
		String[] ele;
		Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        scanner.close();
        ele=input.split("\\s+");
		Set<Integer> a = new LinkedHashSet<Integer>();
        for (String str : ele) {
            a.add(Integer.parseInt(str));
        }

        decide.setConditions(a);
        decide.getDecide();
	}
}
class Decide{
	public Map<Integer, String> xMap = new HashMap<Integer, String>();
    public Map<Integer, String> zMap = new HashMap<Integer, String>();
    void init() {   
        xMap.put(1, "该动物有毛");
        xMap.put(2, "该动物有奶");
        xMap.put(3, "该动物有羽毛");
        xMap.put(4, "该动物会飞");
        xMap.put(5, "会下蛋");
        xMap.put(6, "该动物吃肉");
        xMap.put(7, "该动物有犬齿");
        xMap.put(8, "有爪");
        xMap.put(9, "眼盯前方");
        xMap.put(10, "有蹄");
        xMap.put(11, "是反刍动物");
        xMap.put(12, "是黄褐色");
        xMap.put(13, "身上有暗斑点");
        xMap.put(14, "身上有黑色条纹");
        xMap.put(15, "有长脖子");
        xMap.put(16, "有长腿");
        xMap.put(17, "不会飞");
        xMap.put(18, "有黑白二色");
        xMap.put(19, "会游泳");
        xMap.put(20, "善飞");

        zMap.put(1, "该动物是哺乳动物");
        zMap.put(2, "该动物是鸟");
        zMap.put(3, "该动物是食肉动物");
        zMap.put(4, "该动物是有蹄类动物");
        
        zMap.put(5, "该动物是金钱豹");
        zMap.put(6, "该动物是虎");
        zMap.put(7, "该动物是长颈鹿");
        zMap.put(8, "该动物是斑马");
        zMap.put(9, "该动物是鸵鸟");
        zMap.put(10, "该动物是企鹅");
        zMap.put(11, "该动物是信天翁");
    }
    public void setConditions(Set<Integer> x1) {
        this.x = x1;
    }
    private Set<Integer> x;
    private Set<Integer> z = new LinkedHashSet<Integer>();
    private boolean startDecide() {
        // R1
        if (x.contains(1)) {
            z.add(1);
        }
        // R2
        if (x.contains(2)) {
            z.add(1);
        }
        // R3
        if (x.contains(3)) {
            z.add(2);
        }
        // R4
        if (x.contains(4) && x.contains(5)) {
            z.add(2);
        }
        // R5
        if (x.contains(6)) {
            z.add(3);
        }
        // R6
        if (x.contains(7) && x.contains(8) && x.contains(9)) {
            z.add(3);
        }
        // R7
        if (z.contains(1) && x.contains(10)) {
            z.add(4);
        }
        // R8
        if (z.contains(1) && x.contains(11)) {
            z.add(4);
        }
        // R9
        if (z.contains(1) && z.contains(3) && x.contains(12) && x.contains(13)) {
            z.add(5);
        }
        // R10
        if (z.contains(1) && z.contains(3) && x.contains(12) && x.contains(14)) {
            z.add(6);
        }
        // R11
        if (z.contains(4) && x.contains(15) && x.contains(16) && x.contains(13)) {
            z.add(7);
        }
        // R12
        if (z.contains(4) && x.contains(14)) {
            z.add(8);
        }
        // R13
        if (z.contains(2) && x.contains(15) && x.contains(16) && x.contains(17)
                && x.contains(18)) {
            z.add(9);
        }
        // R14
        if (z.contains(2) && x.contains(19) && x.contains(17) && x.contains(18)) {
            z.add(10);
        }
        // R15
        if (z.contains(2) && x.contains(20)) {
            z.add(11);
        }
		return true;
    }
        //获得结论
        public void getDecide() {
            Set<Integer> temp=new HashSet<Integer>();
            if (!startDecide()) {
                return;
            }
            //作用域，基于范围的for循环
            for (int i : z) {
            	//1~4为中间结论
                if (i < 5) {
                    continue;
                }
                temp.add(i);
            }
            if (temp.size() == 0) {
                System.out.println("不符合条件！");
                return;
            }
            if(temp.size()>1) {
                for (int i : temp) {
                    System.out.println(zMap.get(i));
                }
            	 System.out.printf("匹配到%d个结果，仅供参考\n",temp.size());
            	 return;
            }
            for (int i : temp) {
                System.out.println(zMap.get(i));
            }
    }
}