package KimYeongHan.SpringLecture4Servlet.web.frontcontroller.v3.controller;

import KimYeongHan.SpringLecture4Servlet.web.frontcontroller.ModelView;
import KimYeongHan.SpringLecture4Servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
