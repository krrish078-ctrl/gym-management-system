package com.gymmanagement.system.controller;

import com.gymmanagement.system.model.Attendance;
import com.gymmanagement.system.model.Member;
import com.gymmanagement.system.model.Trainer;
import com.gymmanagement.system.service.AttendanceService;
import com.gymmanagement.system.service.MemberService;
import com.gymmanagement.system.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GymController {

    private final MemberService memberService;
    private final TrainerService trainerService;
    private final AttendanceService attendanceService;

    public GymController(
            MemberService memberService,
            TrainerService trainerService,
            AttendanceService attendanceService) {

        this.memberService = memberService;
        this.trainerService = trainerService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
                "memberCount",
                memberService.getAllMembers().size()
        );

        model.addAttribute(
                "trainerCount",
                trainerService.getAllTrainers().size()
        );

        model.addAttribute(
                "attendanceCount",
                attendanceService.getAllAttendance().size()
        );

        return "index";
    }

    @GetMapping("/members")
    public String members(Model model) {

        model.addAttribute(
                "members",
                memberService.getAllMembers()
        );

        model.addAttribute("member", new Member());

        return "members";
    }

    @PostMapping("/members/add")
    public String addMember(@ModelAttribute Member member) {

        memberService.saveMember(member);

        return "redirect:/members";
    }

    @GetMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable Long id) {

        memberService.deleteMember(id);

        return "redirect:/members";
    }

    @GetMapping("/trainers")
    public String trainers(Model model) {

        model.addAttribute(
                "trainers",
                trainerService.getAllTrainers()
        );

        model.addAttribute("trainer", new Trainer());

        return "trainers";
    }

    @PostMapping("/trainers/add")
    public String addTrainer(@ModelAttribute Trainer trainer) {

        trainerService.saveTrainer(trainer);

        return "redirect:/trainers";
    }

    @GetMapping("/trainers/delete/{id}")
    public String deleteTrainer(@PathVariable Long id) {

        trainerService.deleteTrainer(id);

        return "redirect:/trainers";
    }

    @GetMapping("/attendance")
    public String attendance(Model model) {

        model.addAttribute(
                "attendance",
                attendanceService.getAllAttendance()
        );

        model.addAttribute("record", new Attendance());

        return "attendance";
    }

    @PostMapping("/attendance/add")
    public String addAttendance(
            @ModelAttribute("record") Attendance attendance) {

        attendanceService.saveAttendance(attendance);

        return "redirect:/attendance";
    }
}
