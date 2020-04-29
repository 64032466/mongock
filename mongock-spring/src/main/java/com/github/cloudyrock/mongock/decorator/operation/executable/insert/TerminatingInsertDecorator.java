package com.github.cloudyrock.mongock.decorator.operation.executable.insert;

import com.github.cloudyrock.mongock.decorator.util.Invokable;
import org.springframework.data.mongodb.core.ExecutableInsertOperation;

import java.util.Collection;

public interface TerminatingInsertDecorator<T> extends Invokable, ExecutableInsertOperation.TerminatingInsert<T>, TerminatingBulkInsertDecorator<T> {

  ExecutableInsertOperation.TerminatingInsert<T> getImpl();

  @Override
  default T one(T object) {
    return getInvoker().invoke(()-> getImpl().one(object));
  }

  @Override
  default Collection<? extends T> all(Collection<? extends T> objects) {
    return getInvoker().invoke(()-> getImpl().all(objects));
  }
}