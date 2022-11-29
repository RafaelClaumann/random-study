
var redis = require("redis");

const host = process.env.REDIS_HOST;
const port = process.env.REDIS_PORT;

async function testCache() {
    var client = redis.createClient({
        host: host,
        port: port
    });

    await client.connect();

    console.log("\nCache command: PING");
    console.log("Cache response : " + await client.ping());

    console.log("\nDone");
    process.exit();
}

testCache();