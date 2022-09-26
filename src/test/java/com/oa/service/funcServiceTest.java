package com.oa.service;

import com.oa.entity.Node;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class funcServiceTest extends TestCase {

    private FuncService funcService = new FuncService();

    @Test
    public void testSelectNodeByUserId() {
        List<Node> nodes = funcService.selectNodeByUserId(3L);
        for (Node node : nodes) {
            System.out.println(node.getNodeName());
        }
    }
}