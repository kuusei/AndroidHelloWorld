package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new tk.kuusei.helloworld.DataBinderMapperImpl());
  }
}
