import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.zywang.myspring.core.io.DefaultResourceLoader;
import org.zywang.myspring.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ResourceLoaderTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();

        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8192);
        String str;
        while ((str = bf.readLine()) != null) {
            System.out.println(str);
        }
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource(
                "https://github.com/abyces/My-Spring-Framework/tree/master/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
