package autojson.integration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tests")
public class TestCases {

    private List<TestCase> tests;

    @XmlElement(name = "test")
    public List<TestCase> getTests() {
        return tests;
    }

    public void setTests(List<TestCase> test) {
        this.tests = test;
    }

}
