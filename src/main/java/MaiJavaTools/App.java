package MaiJavaTools;

import MaiJavaTools.DataStructure.FindMinPathFrom2DArray;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "===== Start =========" );
        FindMinPathFrom2DArray ex1 = new FindMinPathFrom2DArray();
        ex1.printArray(FindMinPathFrom2DArray.sampleMatrix);
        List<Point> minPath = ex1.findMinPath(new Point(0,0)
                                            , new Point(FindMinPathFrom2DArray.sampleMatrix[0].length-1, FindMinPathFrom2DArray.sampleMatrix.length-1)
                                            , FindMinPathFrom2DArray.sampleMatrix);

        ex1.printPathAndCost(minPath, FindMinPathFrom2DArray.sampleMatrix);

        //ex2
        minPath = ex1.findMinPath(new Point(2, 2)
                                    , new Point(1,0)
                                    , FindMinPathFrom2DArray.sampleMatrix);
        ex1.printPathAndCost(minPath, FindMinPathFrom2DArray.sampleMatrix);
        //SpringApplication.run(App.class, args);

    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    public static void BitOperations(){
        int n = 1001, m=19, i=2, j=6;

        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(-7));
        BitOperationsUtil bitOperationsUtil = BitOperationsUtil.getInstance();
        System.out.println(bitOperationsUtil.toString());
        //System.out.println(BitOperationsUtil.intToBinaryString(n >>> 3));

        System.out.println(bitOperationsUtil.intToBinaryString(m));
        System.out.println(bitOperationsUtil.intToBinaryString(n));
        System.out.println(bitOperationsUtil.intToBinaryString(m << i));
        System.out.println(bitOperationsUtil.intToBinaryString(n ^ (m << i)));

        // Reset bit j (inclusive) to i to be 1s
        System.out.println(bitOperationsUtil.intToBinaryString(~0 << j+1)); // +1 to be inclusive
        System.out.println(bitOperationsUtil.intToBinaryString(~0 << i));
        System.out.println(bitOperationsUtil.intToBinaryString((~0 << j+1) ^ (~0 << i)));

        System.out.println(bitOperationsUtil.intToBinaryString(n));
    }
}
