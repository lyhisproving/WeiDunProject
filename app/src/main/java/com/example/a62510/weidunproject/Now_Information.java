package com.example.a62510.weidunproject;

import java.util.List;

/**
 * Created by 62510 on 2018/8/28.
 */

public class Now_Information {
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
            private List<String> field;
            private String metric;
            private int rawCount;
            private List<Groups> groups;
           // private List<String> tags;

            public void setField(){
                this.field = field;
            }
            public List<String> getField(){
                return field;
            }
            public void setMetric(){
                this.metric = metric;
            }
            public String getMetric(){
                return metric;
            }
            public void setRawCount(){
                this.rawCount = rawCount;
            }
            public int getRawCount(){
                return rawCount;
            }

//            public void setTags(){
//                this.tags = tags;
//            }
//            public List<String> getTags(){
//                return tags;
//            }

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
                    private Tags tags;
                    private String type;

                    public void setName(){
                        this.name = name;
                    }
                    public String getName(){
                        return name;
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

                    public void setType(){
                        this.type=type;
                    }
                    public String getType(){
                        return type;
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
