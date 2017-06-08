package com.century.weather.data.validator;

import io.reactivex.Observable;
import java.util.regex.Pattern;
import com.century.weather.data.exception.InvalidEmailException;

/**
 * Created by CUSDungVT on 5/3/2017.
 */

public class EmailValidator {
  private static final Pattern EMAIL_ADDRESS
      = Pattern.compile(
      "[a-zA-Z0-9\\+\\._%\\-\\+]{1,256}" +
          "@" +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
          "(" +
          "\\." +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
          ")+"
  );

  public boolean isValid(CharSequence email) {
    return email != null && EMAIL_ADDRESS.matcher(email).matches();
  }

  public Observable<Boolean> checkEmail(CharSequence email) {
    return Observable.fromCallable(() -> {
      if (isValid(email)) {
        return true;
      }
      throw new InvalidEmailException();
    });
  }
}
