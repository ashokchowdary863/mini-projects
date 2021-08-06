import redis

r = redis.StrictRedis('localhost', 6379)

r.set("python_1", "one")
print(r.get("python_1"))