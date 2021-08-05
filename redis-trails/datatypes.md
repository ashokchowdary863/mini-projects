
## Data Types ##

### Strings ###

```shell
set name Thor
get name

del name

set name david
set NAME David

key *

# Redis is case sensitive....
get name
get NAME

# Counters
set seq_id 1
get seq_id

incr seq_id

#Returns no of keys
dbsize

#Multi set
mset apple 1 banana 2 grapes 3

#Multi get
mget apple banana grapes

#Check key exists or not
exists apple

#TTL(EX - Seconds, PX - milliseconds...)
set temp_key temp_val EX 15

expire apple 15

#To reset expiration on a key
persist apple
```


### Lists ###

```shell
#lpush adds to the beginning of the list, rpush adds to the end of the list
rpush names thor captain
lpush names stark
lpush names black-widow

#to list all the values
lrange names 0 -1

#to get starting two
lrange names 0 1

#length
llen names

#delete items
lpop names
rpop names

#Remove items outside the range
ltrim names 0 1
```

### Hashes ###
```shell
hset fruit apple 100 banana 200 grape 300

#get single item
hget fruit grape

#multi get
hmget fruit apple grape
```

### Sets ###
```shell
sadd users user0
sadd users user1 user2 user3

#count 
scard users

#list
smembers users

#diff
sadd set1 a1 a2 a3
sadd set2 a1 a5 a6
sdiff set1 set2 #set1 - set2
sdiff set2 set1 #set2 - set1

#check key exist
sismember users user1

```
