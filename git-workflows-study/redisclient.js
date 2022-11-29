
var redis = require("redis");

console.log(process.env.REDIS_HOST);
console.log(process.env.REDIS_PORT);

async function testCache() {
    var client = redis.createClient({
        host: process.env.REDIS_HOST,
        port: process.env.REDIS_PORT
    });

    await client.connect();

    console.log("\nCache command: PING");
    console.log("Cache response : " + await client.ping());

    console.log("\nDone");
    process.exit();
}

testCache();