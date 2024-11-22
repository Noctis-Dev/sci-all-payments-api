CREATE TABLE `payment_profiles` (
  `payment_profile_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `payment_profile_uuid` varchar(36) UNIQUE NOT NULL,
  `profile_name` varchar(100) UNIQUE NOT NULL,
  `account_email` varchar(100) UNIQUE NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `oauth_url` varchar(255) NOT NULL,
  `oauth_token` varchar(255)
);

CREATE TABLE `payments` (
  `payment_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `payment_uuid` varchar(36) UNIQUE NOT NULL,
  `amount` double NOT NULL,
  `payer_name` varchar(100) NOT NULL,
  `payer_email` varchar(100) NOT NULL,
  `payer_phone` varchar(20) NOT NULL,
  `payment_profile_id` bigint
);

ALTER TABLE `payments` ADD FOREIGN KEY (`payment_profile_id`) REFERENCES `payment_profiles` (`payment_profile_id`);
