package com.example.a62510.weidunproject;

import java.security.acl.Group;
import java.util.List;

/**
 * Created by 62510 on 2018/4/18.
 */
//用来查询数据的详细信息
class Device_Information {
    private String err_msg;
    private int code;
    private Data data;

    public String getErr_msg(){
        return err_msg;
    }
    public void setErr_msg(){
        this.err_msg = err_msg;
    }
    public int getCode(){
        return code;
    }
    public void setCode(){
        this.code = code;
    }

    public class Data{
        private List<Results> results;

        public class Results{
            private String field;
            private String cotwo;
            private int rawCount;
            private List<Groups> groups;

            public void setField(){
                this.field = field;
            }
            public String getField(){
                return field;
            }
            public void setCotwo(){
                this.cotwo = cotwo;
            }
            public String getCotwo(){
                return cotwo;
            }
            public void setRawCount(){
                this.rawCount = rawCount;
            }
            public int getRawCount(){
                return rawCount;
            }

            public class Groups{
                private List<GroupInfo> groupInfos;
                private List<Value> values;

                public class Value{
                    private List<String> value;

                    public void setValue(){
                        this.value = value;
                    }
                    public List<String> getValue(){
                        return value;
                    }

                }
                public void setValues(){
                    this.values = values;
                }
                public List<Value> getValues(){
                    return values;
                }

                public class GroupInfo{
                    private String name;
                    private String type;
                    private Tags tags;

                    public void setName(){
                        this.name = name;
                    }
                    public String getName(){
                        return name;
                    }
                    public void setType(){
                        this.type = type;
                    }
                    public String getType(){
                        return type;
                    }

                    public class Tags{
                        private String device;
                        private String model;

                        public void setDevice() {
                            this.device = device;
                        }
                        public String getDevice(){
                            return device;
                        }
                        public void setModel(){
                            this.model = model;
                        }
                        public String getModel(){
                            return model;
                        }
                    }
                    public void setTags() {
                        this.tags = tags;
                    }
                    public Tags getTags(){
                        return tags;
                    }
                }
                public void setGroupInfos(){
                    this.groupInfos = groupInfos;
                }
                public List<GroupInfo> getGroupInfos(){
                    return groupInfos;
                }

            }
            public void setGroups(){
                this.groups = groups;
            }
            public List<Groups> getGroups(){
                return groups;
            }

        }
        public void setResults(){
            this.results = results;
        }
        public List<Results> getResults(){
            return results;
        }

    }
    public Data getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }

}
