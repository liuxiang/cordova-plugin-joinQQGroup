#import "JoinQQGroup.h"
#import <Cordova/CDVPluginResult.h>

@implementation JoinQQGroup

- (void)open:(CDVInvokedUrlCommand *)command{

    NSDictionary *params = [command.arguments objectAtIndex:0];
    NSString *uin = [params objectForKey:@"uin"];
    NSString *key = [params objectForKey:@"key"];

    NSString *urlStr = [NSString stringWithFormat:@"mqqapi://card/show_pslcard?src_type=internal&version=1&uin=%@&key=%@&card_type=group&source=external", uin,key];
    //NSString *urlStr = [NSString stringWithFormat:@"mqqapi://card/show_pslcard?src_type=internal&version=1&uin=%@&key=%@&card_type=group&source=external", @"498644453",@"6ee13036eb460cdc01956799fae6c917dbe828a11dc624aaf23753317ba4ff07"];

    NSURL *url = [NSURL URLWithString:urlStr];
    if([[UIApplication sharedApplication] canOpenURL:url]){
        [[UIApplication sharedApplication] openURL:url];
        //return YES;
    }
    //else return NO;
}

@end
