package com.systems.caloriecounter.service;

import com.systems.caloriecounter.DTO.request.CreateProfileRequest;
import com.systems.caloriecounter.DTO.request.EditProfileRequest;
import com.systems.caloriecounter.DTO.response.*;
import java.util.Date;
import java.util.List;

public interface ProfileService {
  CreateProfileResponse addProfile(CreateProfileRequest request);
  List<ProfileDTO> getProfiles();

  List<MealDTO> getHistory(Long profileId, Date fromDate, Date toDate);

  EditProfileResponse editProfile(Long profileId, EditProfileRequest request);

  DeleteProfileResponse deleteProfile(Long profileId);
  CheckResponse getCaloriesCheck(Long profileId, Date date);

  ReportResponse getDailyReport(Long profileId, Date date);
}
