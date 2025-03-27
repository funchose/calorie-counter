package com.systems.caloriecounter.controller;

import com.systems.caloriecounter.DTO.request.CreateProfileRequest;
import com.systems.caloriecounter.DTO.request.EditProfileRequest;
import com.systems.caloriecounter.DTO.response.*;
import com.systems.caloriecounter.service.ProfileService;
import jakarta.validation.Valid;
import java.sql.Date;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfileController {

  private final ProfileService profileService;

  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }

  @GetMapping("/profiles")
  public List<ProfileDTO> getProfiles() {
    return profileService.getProfiles();
  }

  @GetMapping("/profiles/{profileId}/dailyreport")
  public ReportResponse getDailyReport(@PathVariable Long profileId,
                                       @RequestParam(required = false) Date date) {
    return profileService.getDailyReport(profileId, date);
  }
  @GetMapping("/profiles/{profileId}/history")
  public List<MealDTO> getHistory(@PathVariable Long profileId,
                                  @RequestParam(name = "fromDate", required = false) Date fromDate,
                                  @RequestParam(name = "toDate", required = false) Date toDate) {
    return profileService.getHistory(profileId, fromDate, toDate);
  }

  @GetMapping("/profiles/{profileId}/check")
  public CheckResponse getCaloriesCheck(@PathVariable Long profileId,
                                        @RequestParam(name = "date", required = false) Date date) {
    return profileService.getCaloriesCheck(profileId, date);
  }

  @PostMapping("/profiles")
  public CreateProfileResponse addProfile(@Valid @RequestBody CreateProfileRequest request) {
    return profileService.addProfile(request);
  }

  @PutMapping("/profiles/{profileId}")
  public EditProfileResponse editProfile(@PathVariable Long profileId,
                                         @RequestBody EditProfileRequest request) {
    return profileService.editProfile(profileId, request);
  }

  @DeleteMapping("/profiles/{profileId}")
  public DeleteProfileResponse deleteProfile(@PathVariable Long profileId) {
    return profileService.deleteProfile(profileId);
  }
}
