/*
Copyright 2011 NativeDriver committers
Copyright 2011 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.google.android.testing.nativedriver.client;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.android.testing.nativedriver.common.AndroidNativeDriverCommand;
import com.google.android.testing.nativedriver.common.FindsByText;
import com.google.android.testing.nativedriver.common.HasSetText;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/**
 * Represents an element on the client side. Objects of this type are identical
 * to {@code RemoteWebElement} objects, but in addition support finding by
 * text. The code in this class intercepts calls to the methods on
 * {@code FindsByText} and causes the correct JSON commands to be sent to the
 * remote session.
 *
 * @author Matt DeVore
 */
public class AndroidNativeElement
    extends RemoteWebElement implements FindsByText, HasSetText {
  /**
   * Constructs a new instance and sets the parent WebDriver object.
   *
   * @param parent the parent WebDriver of the new instance
   */
  public AndroidNativeElement(AndroidNativeDriver parent) {
    setParent(Preconditions.checkNotNull(parent));
  }

  @Override
  public WebElement findElementByPartialText(String using) {
    return findElement(USING_PARTIALTEXT, using);
  }

  @Override
  public WebElement findElementByText(String using) {
    return findElement(USING_TEXT, using);
  }

  @Override
  public List<WebElement> findElementsByPartialText(String using) {
    return findElements(USING_PARTIALTEXT, using);
  }

  @Override
  public List<WebElement> findElementsByText(String using) {
    return findElements(USING_TEXT, using);
  }
  
//  public void setText(CharSequence[] keysToSend) {
  public void setText(String value) {
//    execute("sendKeysToElement", ImmutableMap.of("id", this.id, "value", keysToSend));
//    execute("setText", ImmutableMap.of("id", this.id, "value", value));
//    execute(AndroidNativeDriverCommand.SEND_KEYS_TO_SESSION,
//        ImmutableMap.of("value", keysToSend));
    execute(AndroidNativeDriverCommand.SET_TEXT_TO_ELEMENT,
        ImmutableMap.of("value", value));
//    execute("setText", ImmutableMap.of("id", this.id, "value", value));
  }

  
  
}
