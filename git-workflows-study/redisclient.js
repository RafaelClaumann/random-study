
var redis = require("redis");

async function testCache() {
    var client = redis.createClient({
        host: process.env.REDIS_HOST,
        port: process.env.REDIS_PORT,
        tls: {}
    });

    await client.connect();

    console.log("\nCache command: PING");
    console.log("Cache response : " + await client.ping());

    console.log("\nDone");
    process.exit();
}

testCache();