package com.github.cloudyrock.mongock.driver.mongodb.v3.decorator.impl;

import com.mongodb.client.MongoCollection;
import io.changock.driver.api.lock.guard.invoker.LockGuardInvoker;
import com.github.cloudyrock.mongock.driver.mongodb.v3.decorator.MongoCollectionDecorator;

public class MongoCollectionDecoratorImpl<T> implements MongoCollectionDecorator<T> {

  private final MongoCollection<T> impl;
  private final LockGuardInvoker lockChecker;

  public MongoCollectionDecoratorImpl(MongoCollection<T> implementation, LockGuardInvoker lockerCheckInvoker) {
    this.impl = implementation;
    this.lockChecker = lockerCheckInvoker;
  }

  @Override
  public MongoCollection<T> getImpl() {
    return impl;
  }

  @Override
  public LockGuardInvoker getInvoker() {
    return lockChecker;
  }

}
