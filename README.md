# the-earliest-available-period-of-bathroom

## How to run the tests

`lein midje` will run all tests.

`lein midje the-earliest-available-period-of-bath.*` will run only tests beginning within this namespace.

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## Kata：集合函数练习
一家澡堂有 m 个房间，每个房间有 n 个时段，现在要给用户推荐「最早的可以预约的时段」。

例子：
```
rooms: [
  {
     room_id: 1,
     periods: [
        {
           time: '17:00-18:00',
           status: 'available'
        },
        {
           time: '18:00-19:00',
           status: 'occupied'
        }
     ]
  }, {
     room_id: 2,
     periods: [
        {
           time: '17:00-18:00',
           status: 'occupied'
        },
        {
           time: '18:00-19:00',
           status: 'available'
        }
     ]
  }
]
```

期望返回：
```
{
  room_id: 1,
  time: '17:00-18:00'
}
```
## 假设
* periods中的时间段是从低到高排序的

## Tasking（拆分任务）
- [x] 单间澡堂有一个可用时间段
- [x] 单间澡堂有多个可用时间段
- [x] 所有澡堂（包含输入为空）没有可用时间
- [x] 多间澡堂都有可用时间段
- [x] 多间澡堂中有的有可用时间段，有得没有可用时间段