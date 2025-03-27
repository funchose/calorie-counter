package com.systems.caloriecounter.service;

import com.systems.caloriecounter.DTO.request.CreateProfileRequest;
import com.systems.caloriecounter.DTO.request.EditProfileRequest;
import com.systems.caloriecounter.DTO.response.*;
import com.systems.caloriecounter.exceptions.ProfileNotFoundException;
import com.systems.caloriecounter.model.Profile;
import com.systems.caloriecounter.repository.MealRepository;
import com.systems.caloriecounter.repository.ProfileRepository;
import com.systems.caloriecounter.utils.CalorieCalculator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class ProfileServiceImpl implements ProfileService {
  private final ProfileRepository profileRepository;
  private final MealRepository mealRepository;

  public ProfileServiceImpl(ProfileRepository profileRepository, MealRepository mealRepository) {
    this.profileRepository = profileRepository;
    this.mealRepository = mealRepository;
  }

  @Transactional
  @Override
  public CreateProfileResponse addProfile(CreateProfileRequest request) {
    var profile = new Profile()
        .setName(request.getName())
        .setAge(request.getAge())
        .setHeight(request.getHeight())
        .setWeight(request.getWeight())
        .setEmail(request.getEmail())
        .setGender(request.getGender())
        .setActivity(request.getActivity())
        .setGoal(request.getGoal())
        .setActive(true);
    var calorieNorm = CalorieCalculator.calculateCaloriesRate(profile);
    switch (profile.getGoal()) {
      case GAIN_WEIGHT -> calorieNorm += 300;
      case LOSE_WEIGHT -> calorieNorm = Math.max(calorieNorm - 300, 1200);
    }
    profile.setCalorieNorm(calorieNorm);
    var addedProfile = profileRepository.save(profile);
    return new CreateProfileResponse()
        .setId(addedProfile.getId())
        .setName(addedProfile.getName())
        .setCalorieNorm(addedProfile.getCalorieNorm());
  }

  @Transactional(noRollbackFor = MethodArgumentNotValidException.class)
  @Override
  public EditProfileResponse editProfile(Long profileId, EditProfileRequest request) {
    var profile = profileRepository.findById(profileId)
        .orElseThrow(() -> new ProfileNotFoundException(profileId));
    if (request.getName() != null) {
      profile.setName(request.getName());
    }
    if (request.getEmail() != null) {
      profile.setEmail(request.getEmail());
    }
    if (request.getAge() != null) {
      profile.setAge(request.getAge());
    }
    if (request.getGender() != null) {
      profile.setGender(request.getGender());
    }
    if (request.getHeight() != null) {
      profile.setHeight(request.getHeight());
    }
    if (request.getWeight() != null) {
      profile.setWeight(request.getWeight());
    }
    if (request.getActivity() != null) {
      profile.setActivity(request.getActivity());
    }
    if (request.getGoal() != null) {
      profile.setGoal(request.getGoal());
    }
    profile.setCalorieNorm(CalorieCalculator.calculateCaloriesRate(profile));
    var editedProfile = profileRepository.save(profile);
    return new EditProfileResponse()
        .setId(editedProfile.getId())
        .setName(editedProfile.getName())
        .setCalorieNorm(editedProfile.getCalorieNorm());
  }

  @Transactional
  @Override
  public DeleteProfileResponse deleteProfile(Long profileId) {
    var profile = profileRepository.findById(profileId)
        .orElseThrow(() -> new ProfileNotFoundException(profileId));
    profile.setActive(false);
    profileRepository.save(profile);
    return new DeleteProfileResponse().setId(profileId);
  }

  @Transactional
  @Override
  public CheckResponse getCaloriesCheck(Long profileId, Date date) {
    var profile = profileRepository.findById(profileId)
        .orElseThrow(() -> new ProfileNotFoundException(profileId));
    java.sql.Date requestDate = Objects.requireNonNullElseGet((java.sql.Date) date,
        () -> new java.sql.Date(new Date().getTime()));
    Integer currentCalories = Objects.requireNonNullElse(
        mealRepository.countCaloriesSum(profile, requestDate), 0);
    String responseMessage;
    if (currentCalories <= profile.getCalorieNorm()) {
      responseMessage = "You didn't exceed your daily calories limit!";
    } else {
      responseMessage = "You have exceeded your daily calories limit!";
    }
    return new CheckResponse()
        .setProfileId(profileId)
        .setName(profile.getName())
        .setCurrentCalories(currentCalories)
        .setCalorieNorm(profile.getCalorieNorm())
        .setResponse(responseMessage)
        .setDate(requestDate);
  }

  @Transactional
  @Override
  public ReportResponse getDailyReport(Long profileId, Date date) {
    var profile = profileRepository.findById(profileId)
        .orElseThrow(() -> new ProfileNotFoundException(profileId));
    java.sql.Date requestDate = Objects.requireNonNullElseGet((java.sql.Date) date,
        () -> new java.sql.Date(new Date().getTime()));
    Integer currentCalories = Objects.requireNonNullElse(
        mealRepository.countCaloriesSum(profile, requestDate), 0);
    var meals = mealRepository.findMealsByProfileIdAndMealDate(profileId, requestDate)
        .stream().map(MealReportDTO::new).toList();
    return new ReportResponse()
        .setName(profile.getName())
        .setProfileId(profileId)
        .setCalories(currentCalories)
        .setDate(requestDate)
        .setMeals(meals);
  }

  @Transactional
  @Override
  public List<ProfileDTO> getProfiles() {
    return profileRepository.findAll().stream().map(ProfileDTO::new).toList();
  }

  @Transactional
  @Override
  public List<MealDTO> getHistory(Long profileId, Date fromDate, Date toDate) {
    java.sql.Date from = Objects.requireNonNullElseGet((java.sql.Date) fromDate,
        () -> new java.sql.Date(0L));
    java.sql.Date to = Objects.requireNonNullElseGet((java.sql.Date) toDate,
        () -> new java.sql.Date(new Date().getTime()));
    return mealRepository.findMealsByProfileIdAndMealDateBetween(profileId, from, to)
        .stream().map(MealDTO::new).toList();
  }
}
