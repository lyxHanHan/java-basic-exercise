import java.util.List;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> inputStrList = getInputStrList();
        if (null == inputStrList) {
            System.exit(0);
        }

        List<String> collect = inputStrList.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.comparing(String::trim))
                .collect(Collectors.toList());
        System.out.println("处理结果:" + collect);

    }

    public static List<String> getInputStrList(){
        Scanner WordList = new Scanner(System.in);
        System.out.println("请输入英文单词, 使用英文逗号(,)隔开 回车键结束输入:");
        String inputStr = WordList.nextLine();
        System.out.println("输入内容:" + inputStr);
        
        if (null == inputStr || inputStr.length() <= 0) {
            System.out.println("输入的内容不能为空");
            return null;
        }

        String[] split = inputStr.split(",");
        if (split.length <= 0) {
            System.out.println("输入的内容不能为空");
            return null;
        }

        List<String> inputStrList = new ArrayList<String>(Arrays.asList(split));
        if (inputStrList.size() <= 0) {
            System.out.println("输入的内容不能为空");
            return null;
        }

        if (inputStrList.contains("")) {
            System.out.println("input not valid");
            return null;
        }

        inputStrList.stream().forEach(r -> {
            if (r.matches("^[0-9]*$")) {
                System.out.println("input not valid");
                System.exit(0);
            }
        });

        return inputStrList;
    }

    
}
