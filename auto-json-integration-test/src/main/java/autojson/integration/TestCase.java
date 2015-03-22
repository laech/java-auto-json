package autojson.integration;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private String mapper;

    private List<String> cases = new ArrayList<>();
    private List<TestCaseIo> iocases = new ArrayList<>();

    @XmlAttribute(name = "class")
    public String getMapper() {
        return mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    @XmlElement(name = "case")
    public List<String> getCases() {
        return cases;
    }

    public void setCases(List<String> cases) {
        this.cases = cases;
    }

    @XmlElement(name = "iocase")
    public List<TestCaseIo> getIocases() {
        return iocases;
    }

    public void setIocases(List<TestCaseIo> iocases) {
        this.iocases = iocases;
    }
}
